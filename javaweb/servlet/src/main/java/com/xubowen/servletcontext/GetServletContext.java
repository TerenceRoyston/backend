package com.xubowen.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author XuBowen
 * @date 2021/11/6 16:28
 */
@WebServlet(name = "GetServletContext")
public class GetServletContext extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建ServletContext对象
        ServletContext sc = this.getServletContext();
        System.out.println(sc.getAttribute("str"));


    }
}
