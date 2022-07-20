package com.xubowen.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author XuBowen
 * @date 2021/11/3 20:58
 *
 * cookie 学习
 *
 */
@WebServlet(name = "CookieServlet")
public class CookieServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置请求编码格式
		req.setCharacterEncoding("utf-8");
		// 设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");

		// 使用cookie进行浏览器端数据存储
		Cookie cookie1 = new Cookie("language", "java");
		Cookie cookie2 = new Cookie("language", "python");
		// 设置cookie有效期
		cookie2.setMaxAge(3*24*3600);
		cookie2.setPath("/servlet/getcookie");
		// 响应cookie信息
		resp.addCookie(cookie1);
		resp.addCookie(cookie2);
		// 直接响应
		resp.getWriter().write("cookie 学习");


	}
}
