package com.calcfab.controller;

import com.calcfab.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XuBowen
 * @date 2023/02/25 22:17
 */
@RestController
@RequestMapping("api")
public class UserController {
    @Autowired
    UserDao userDao;

    @RequestMapping("/demo_1")
    public String demo_1(){
        return userDao.selectList(null).toString();
    }
}
