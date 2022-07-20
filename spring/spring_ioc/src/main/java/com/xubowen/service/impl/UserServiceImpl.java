package com.xubowen.service.impl;

import com.xubowen.service.UserService;

/**
 * @author XuBowen
 * @date 2022/1/23 15:06
 */
public class UserServiceImpl implements UserService {
    @Override
    public String testIOCService() {
        System.out.println("I am UserServiceImpl");
        return "Spring IOC";
    }
}
