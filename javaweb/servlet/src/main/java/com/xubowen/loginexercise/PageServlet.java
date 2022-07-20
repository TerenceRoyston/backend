package com.xubowen.loginexercise;

		import javax.servlet.ServletException;
		import javax.servlet.http.HttpServlet;
		import javax.servlet.http.HttpServletRequest;
		import javax.servlet.http.HttpServletResponse;
		import java.io.IOException;

/**
 * @author XuBowen
 * @date 2021/10/31 22:12
 */

public class PageServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");

		// 获取请求信息


		// 处理请求


		// 响应处理结果

		// 获取request作用域数据
		String str = (String) req.getAttribute("str") == null ? "" : (String) req.getAttribute("str");
		System.out.println(str);

		resp.getWriter().write("<html>");
		resp.getWriter().write("<head>");
		resp.getWriter().write("</head>");


		resp.getWriter().write("<body>");
		resp.getWriter().write("<font color='red' size='20px'>" + str + "</font>");
		resp.getWriter().write("<form action ='load' method='get '>");
		resp.getWriter().write("用户名<input type='text' name='username' value='' /> <br>");
		resp.getWriter().write("密码<input type='text' name='password' value='' /> <br>");
		resp.getWriter().write("<input type='submit'  value='登录' /> <br>");
		resp.getWriter().write("</form>");
		resp.getWriter().write("</body>");

		resp.getWriter().write("</html>");

	}
}
