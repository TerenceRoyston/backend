package com.xubowen.servletconfig;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author XuBowen
 * @date 2021/11/7 14:46
 */
@WebServlet(name = "ServletConfigServlet")
public class ServletConfigServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取ServletConfig对象
        ServletConfig config = this.getServletConfig();
        // 获取在web.xml中针对某个servlet的单独配置
        String parameter = config.getInitParameter("config");
        System.out.println(parameter);
    }
}
