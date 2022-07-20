package com.xubowen.controller;

import com.xubowen.staticproxy.pojo.User;
import com.xubowen.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author XuBowen
 * @date 2022/2/13 21:58
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        userService = (UserService) ac.getBean("us");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");


        User user = userService.userLoginService(uname, pwd);
        System.out.println(user);
        if (user != null) {
            req.getSession().setAttribute("user",user);
            System.out.println(req.getContextPath());
            resp.sendRedirect(req.getContextPath()+"/main.jsp");
        } else {

            req.setAttribute("flag","密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
}
