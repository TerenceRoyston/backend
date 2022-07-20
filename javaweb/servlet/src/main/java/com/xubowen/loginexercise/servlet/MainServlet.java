package com.xubowen.loginexercise.servlet;

import com.xubowen.loginexercise.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author XuBowen
 * @date 2021/11/3 19:27
 *
 * 登陆成功后的主页
 */

@WebServlet(name = "MainServlet")
public class MainServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置请求编码格式
		req.setCharacterEncoding("utf-8");
		// 设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");

		// 获取请求信息
		User u = (User) req.getSession().getAttribute("user");
		// 获取网页浏览次数
		int nums = (int) this.getServletContext().getAttribute("nums");
		resp.getWriter().write("<html>");

		resp.getWriter().write("<head>");
		resp.getWriter().write("</head>");


		resp.getWriter().write("<body>");
		resp.getWriter().write("<h3>欢迎"+u.getName()+"访问我的页面</h3>");
		resp.getWriter().write("当前网页浏览次数为"+nums);
		resp.getWriter().write("<hr>");

		resp.getWriter().write("</body>");

		resp.getWriter().write("</html>");
	}


}
