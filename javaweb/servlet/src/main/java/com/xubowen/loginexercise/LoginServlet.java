package com.xubowen.loginexercise;

import com.xubowen.loginexercise.pojo.User;
import com.xubowen.loginexercise.service.LoginService;
import com.xubowen.loginexercise.service.impl.LoginServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author XuBowen
 * @date 2021/10/31 22:36
 */
public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// 设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");

		// 获取请求信息 如果返回null，则有可能key写错了，建议修改servlet而不是修改前端页面
		String username = req.getParameter("username");
		// 如果请求乱码，就需要对请求进行转码
		//username=new String(username.getBytes("iso8859-1"), "utf-8");
		String password = req.getParameter("password");
		System.out.println(username + "=>" + password);

		// 处理请求信息
		// 获取业务层对象
		LoginService ls = new LoginServiceImpl();
		User u = null;
		try {
			u= ls.checkLoginService(username, password);
			System.out.println(u);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 响应处理结果
		if (u != null){
			// 请求转发
			// req.getRequestDispatcher("main").forward(req,resp);

			// 创建Cookie，实现3天免登录
			Cookie cookie = new Cookie("id", u.getId() + "");
			// 设置cookie有效期
			cookie.setMaxAge(3*24*3600);
			// 设置cookie触发条件
			cookie.setPath("/servlet/checkcookie");

			// 添加cookie信息
			resp.addCookie(cookie);

			// 将数据存储到session对象中
			HttpSession hs = req.getSession();
			hs.setAttribute("user", u);

			// 创建网页计数器
			// 获取计数数据
			ServletContext context = this.getServletContext();
			// 判断这个计数器是不是已经存在
			if (context.getAttribute("nums")!=null){
				int nums=(int)context.getAttribute( "nums");
				nums+=1;
				// 再存回context中
				context.setAttribute("nums",nums);
			}else {
				context.setAttribute("nums",1);
			}

			// 重定向
			resp.sendRedirect("/servlet/main");
		}else {
			resp.getWriter().write("登录失败");
			 /*
			 * 使用请求转发，登录失败就回到登录页面
			 * 作用:实现多个servlet联动操作处理请求，这样避免代码冗余，让servlet的职责更加明确。
			 * 使用：req.getRequestDispatcher("要转发的地址").forward(req，resp);
			 * 地址:相对路径，直接书写servlet的别名即可。
			 * 注意： 请求转发后直接return结束即可。
			 * */
			req.setAttribute("str","用户名或密码错误");
			req.getRequestDispatcher("page").forward(req,resp);

		}

	}
}
