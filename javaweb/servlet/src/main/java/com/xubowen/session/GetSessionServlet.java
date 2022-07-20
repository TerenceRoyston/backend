package com.xubowen.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author XuBowen
 * @date 2021/11/6 11:37
 */
@WebServlet(name = "GetSessionServlet")
public class GetSessionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession hs = req.getSession();
        System.out.println("获取的sessionId => "+hs.getId());
        System.out.println("获取的session属性 => "+hs.getAttribute("name"));
    }
}
