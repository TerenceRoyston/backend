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
 * @date 2021/11/6 16:21
 */
@WebServlet(name = "ServletContextServlet")
public class ServletContextServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取ServletContext对象
        // (1) 第一种方式
        ServletContext sc = this.getServletContext();
        // (2)第二种方式
        ServletContext sc2 = this.getServletConfig().getServletContext();
        // (3)第三种方式
        ServletContext sc3 = req.getSession().getServletContext();

        // 使用ServletContext对象完成数据共享
        // 数据存储
        sc.setAttribute("str","ServletContext对象学习");

        // 获取项目web.xml全局配置数据
        String value = sc.getInitParameter("name");
        System.out.println("name => "+value);

        // 获取项目根目录下的资源绝对路径
        String path=sc.getRealPath("/webapp/mydir/a.txt");
        System.out.println(path);
    }
}
