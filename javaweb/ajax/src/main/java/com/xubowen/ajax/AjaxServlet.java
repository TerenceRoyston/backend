package com.xubowen.ajax;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author XuBowen
 * @date 2021/12/19 13:31
 */
@WebServlet(name = "/AjaxServlet")
public class AjaxServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求编码格式
        req.setCharacterEncoding("utf-8");
        // 设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");

        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        System.out.println(name+" => "+pwd+req.getMethod());

        String html ="<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "    <h1>Hello</h1>\n" +
                "    <table border=\"1\">\n" +
                "        <tr>\n" +
                "            <th>Month</th>\n" +
                "            <th>Savings</th>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td>January</td>\n" +
                "            <td>$100</td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "</body>\n" +
                "</html>";


        resp.getWriter().write(html);
    }
}
