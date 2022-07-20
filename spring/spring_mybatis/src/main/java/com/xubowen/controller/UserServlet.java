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
 * @date 2022/2/8 21:23
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {

    // 声明业务层属性
    private UserService userService;

    // 声明init方法完成资源初始化加载
    @Override
    public void init() throws ServletException {
        // ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 配置文件名要写在配置文件中，解耦
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

        // 处理请求信息

        User user = userService.userLoginService(uname, pwd);

        if (user != null) {
            resp.getWriter().write("登陆成功");
        } else {
            resp.getWriter().write("登陆失败");
        }


    }
}
