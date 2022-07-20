package com.xubowen.loginexercise;

import com.xubowen.loginexercise.pojo.User;
import com.xubowen.loginexercise.service.LoginService;
import com.xubowen.loginexercise.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author XuBowen
 * @date 2021/11/4 21:58
 * <p>
 * 拿到登录信息后先检测是否有cookie信息
 * <p>
 * cookie信息校验
 * 判断请求中是否携带正确的Cookie信息
 * 如果有则校验Cookie信息是否正确
 * 如果校验正确则直接响应主页面给用户
 * 如果校验不正确则响应登录页面给用户
 * 没有则请求转发给登录页面
 */
@WebServlet(name = "CheckCookieServlet")
public class CheckCookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 核验cookie信息
        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            // 遍历cookie
            String id = "";
            for (Cookie cookie : cookies) {
                if ("id".equals(cookie.getName())) {
                    id = cookie.getValue();
                }
            }
            // 校验id是否存在
            if ("".equals(id)) {
                req.getRequestDispatcher("page").forward(req, resp);
                return;
            } else {
                // 去数据库校验id
                // 获取业务层对象
                LoginService ls = new LoginServiceImpl();
                User u = null;
                try {
                    u = ls.checkLoginService(id);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (u != null) {
                    // 将查出的数据存到session对象
                    HttpSession hs = req.getSession();
                    hs.setAttribute("user", u);
                    // 不为空，说明id在库中存在用户

                    // 获取网页计数器
                    int nums = (int) this.getServletContext().getAttribute("nums");
                    this.getServletContext().setAttribute("nums",nums+=1);

                    resp.sendRedirect("/servlet/main");
                    return;
                } else {
                    req.getRequestDispatcher("page").forward(req, resp);
                }
            }
        } else {
            req.getRequestDispatcher("page").forward(req, resp);
        }
    }
}
