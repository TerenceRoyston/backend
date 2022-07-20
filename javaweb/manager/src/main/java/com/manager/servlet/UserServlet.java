package com.manager.servlet;

import com.manager.pojo.User;
import com.manager.service.UserService;
import com.manager.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author XuBowen
 * @date 2021/11/13 11:36
 */
@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {
    // 声明日志对象
    Logger logger = Logger.getLogger(UserServiceImpl.class);

    // 获取service层对象
    UserService us =new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应编码格式
        resp.setContentType("text/html;charset=utf-8");

        // 获取操作符
        String oper = req.getParameter("oper");
        if (oper.equals("login")){
            // 调用登录处理方法
            checkUserLogin(req,resp);
        }else if (oper.equals("reg")){
            // 调用注册功能
            userReg(req,resp);
        }else if (oper.equals("pwd")){
            // 调用密码功能
            userChangePwd(req,resp);
        }else if (oper.equals("out")){
            // 调用退出功能
            userOut(req,resp);
        }else if (oper.equals("show")){
            // 调用显示所有用户功能
            userShow(req,resp);
        }else {
            logger.debug("没有找到操作符");
            System.out.println("没有找到操作符");
        }

    }



    // 用户退出功能
    private void userOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 获取session对象
        HttpSession hs = req.getSession();
        // 销毁session
        hs.invalidate();
        // 重定向到登录页面
        resp.sendRedirect("/mg/login.jsp");
    }

    // 处理登录
    private void checkUserLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        System.out.println(uname+" => "+pwd);
        // 处理请求信息

        // 校验
        User u = us.checkUserLoginService(uname, pwd);
        System.out.println(u);
        if (u!=null){
            // 获取session对象
            HttpSession hs = req.getSession();
            // 将用户数据存储到session
            hs.setAttribute("user",u);
            // 重定向
            resp.sendRedirect("/mg/main/main.jsp");
            return;
        }else {
            // 添加标识符到request中
            req.setAttribute("flag",0);
            // 请求转发
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
            return;
        }
    }

    // 用户修改密码
    private void userChangePwd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 获取新密码数据
        String newPwd = req.getParameter("newPwd");
        // 从session对象获取用户信息
        User u = (User) req.getSession().getAttribute("user");
        int uid = u.getUid();
        // 处理请求
        // 调用service处理
        int index=us.userChangePwdService(newPwd,uid);
        System.out.println(index);
        if (index > 0){
            // 获取session对象
            HttpSession hs = req.getSession();
            hs.setAttribute("pwd","true");
            resp.sendRedirect("/mg/login.jsp");
        }


    }

    // 显示用户信息
    private void userShow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> lu=us.userShowService();
        System.out.println(lu);
        if (lu !=null){
            req.setAttribute("lu",lu);
            // 请求转发
            req.getRequestDispatcher("/user/showUser.jsp").forward(req,resp);
            return;
        }
    }

    // 用户注册
    private void userReg(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 获取请求信息
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        String sex = req.getParameter("sex");
        int  age = req.getParameter("age").equals("") ? 0:Integer.parseInt(req.getParameter("age"));
        String birth = req.getParameter("birth");
        User u = new User(0,uname,pwd,sex,age,birth);

        System.out.println(uname);
        // 调用业务层处理
        int index =us.userRegService(u);
        System.out.println(index);
        if (index > 0){
            // 获取session对象
            HttpSession hs = req.getSession();
            hs.setAttribute("reg","true");
            // 重定向
            resp.sendRedirect("/mg/login.jsp");
        }
    }
}
