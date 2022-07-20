package com.xubowen.controller;

import com.xubowen.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author XuBowen
 * @date 2022/1/23 15:09
 */

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         // 创建spring容器对象  配置文件放在web-inf目录下
         ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
         // 从容器中获取业务层对象
         UserService us = (UserService) ac.getBean("us");
         // 调用业务层方法处理请求
         String res = us.testIOCService();

        resp.getWriter().write(res);
    }
}
