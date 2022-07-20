package com.xubowen.controller;

import com.xubowen.pojo.User;
import com.xubowen.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author XuBowen
 * @date 2022/2/26 13:37
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("userLogin")
    public String userLogin(String uname,String pwd){
        User user = userService.selUserInfoService(uname, pwd);
        if (user!=null){
            return "redirect:/main.jsp";
        }else {
            return "forward:/login.jsp";
        }
    }
}
