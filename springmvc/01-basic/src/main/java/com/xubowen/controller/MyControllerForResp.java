package com.xubowen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author XuBowen
 * @date 2022/2/24 22:36
 */

@Controller
public class MyControllerForResp {
    // 声明单元方法 完成请求转发 可以转发给页面也可以转发给单元方法  URL不变
    @RequestMapping("demoForward")
    public String demoForward(String uname, Integer age) {
        System.out.println("解耦方式完成请求转发 => " + uname + " : " + age);
        return "forward:/aa.jsp";
    }

    // 完成重定向 URL改变  如果不写冒号前的标识，则默认请求转发
    @RequestMapping("demoRedirect")
    public String demoRedirect(String uname, Integer age) {
        System.out.println("解耦方式完成重定向 => " + uname + " : " + age);
        return "redirect:/aa.jsp";
    }
}
