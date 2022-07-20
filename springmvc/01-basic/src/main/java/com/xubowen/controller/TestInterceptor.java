package com.xubowen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author XuBowen
 * @date 2022/2/27 22:01
 */

@Controller
public class TestInterceptor {
    @RequestMapping("testInterceptor")
    public String testInterceptor(){
        System.out.println("yes");
        return "/aa.jsp";
    }

    @RequestMapping("testInterceptorPostHandle")
    public String testInterceptorPostHandle(){
        return "/aa.jsp";
    }
}
