package com.xubowen.controller;

import com.xubowen.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author XuBowen
 * @date 2022/2/26 14:44
 */

@Controller
public class MyScope {
    // request对象作用域  一次请求
    @RequestMapping("testReq")
    public String testReq(String uname, String pwd, HttpServletRequest request) {
        System.out.println("request对象作用域 => " + uname + pwd);
        request.setAttribute("str", "我是request对象");
        return "forward:/req.jsp";
    }

    // 测试session  一次会话
    @RequestMapping("testSession")
    public String testSession(String uname, String pwd, HttpSession session) {
        System.out.println("session对象作用域 => " + uname + pwd);
        session.setAttribute("str", "我是session对象");
        return "redirect:/session.jsp";
    }

    // Application对象 不同会话
    @RequestMapping("testApplication")
    public String testApplication(String uname, String pwd, HttpSession session) {
        System.out.println("Application对象作用域 => " + uname + pwd);
        // 不能直接拿，要从session或request对象间接拿
        ServletContext context = session.getServletContext();
        context.setAttribute("str", "我是Application对象");
        return "redirect:/application.jsp";
    }

    // Model对象
    @RequestMapping("testModel")
    public String testModel(String uname, String pwd, Model model) {
        System.out.println("Model对象作用域 => " + uname + pwd);
        model.addAttribute("str", "我是model对象");
        // 请求转发时可以当做request对象使用
        // return "forward:/model.jsp";
        // 重定向时能把储存的数据作为请求数据拼到url后面
        return "redirect:/model.jsp";
    }

    // 直接响应给页面
    @ResponseBody
    @RequestMapping(value = "testAjax",produces = "text/html;charset=utf-8")
    public String testAjax(String uname, String pwd){
        System.out.println("响应Ajax请求 => "+uname+pwd);
        return "java好....";
    }

    // 响应java对象到页面
    @ResponseBody
    @RequestMapping(value = "testAjax2",produces = "application/json")
    public User testAjax2(String uname, String pwd){
        System.out.println("响应Ajax2请求 => "+uname+pwd);
        User user = new User("tony", 33);
        return user;
    }

    // 内部请求转发到web-inf目录下资源
    @RequestMapping("demoGet")
    public String demoGet(){
        // WEB-INF就是密室
        return "forward:/WEB-INF/page/my.jsp";
    }

    // 公共单元方法，访问WEB-INF下的静态资源
    @RequestMapping("{aa}")
    public String getJsp(@PathVariable("aa") String myjsp){
        System.out.println(myjsp);
        return "forward:/WEB-INF/page/"+myjsp+".jsp";
    }


}
