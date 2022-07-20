package com.xubowen.service;

import com.xubowen.staticproxy.pojo.User;

/**
 * @author XuBowen
 * @date 2022/2/13 20:52
 */
public interface UserService {
    // 用户登录
    User userLoginService(String uname,String pwd);

}
