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
 * @date 2021/11/3 23:04
 */
@WebServlet(name = "GetCookieServlet")
public class GetCookieServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 设置请求编码格式
		req.setCharacterEncoding("utf-8");
		// 设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");

		// 获取cookie信息
		// 一般应该先访问cookie页面存cookie数据，但用户有可能直接访问GetCookie页面，这时候还没存数据，就会报空指针异常，
		// 浏览器返回500错误
		Cookie[] cookies = req.getCookies();
		if (cookies != null){
			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				String value = cookie.getValue();
				System.out.println(name+" => "+value);
			}
		}


	}
}
