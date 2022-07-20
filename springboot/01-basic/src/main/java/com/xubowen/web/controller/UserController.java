package com.xubowen.web.controller;

import com.xubowen.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author XuBowen
 * @date 2022/3/9 22:17
 */

@Controller
@RequestMapping("users")
public class UserController {
    @Autowired
    private User user;

    @RequestMapping("save")
    @ResponseBody
    public String save(){
        System.out.println("UserController.save");
        System.out.println(user.getName());
        return "index";
    }
}
