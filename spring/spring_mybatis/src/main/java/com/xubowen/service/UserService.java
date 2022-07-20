package com.xubowen.service;

import com.xubowen.staticproxy.pojo.User;

/**
 * @author XuBowen
 * @date 2022/2/7 21:59
 */
public interface UserService {
    public User userLoginService(String uname,String pwd);
}
