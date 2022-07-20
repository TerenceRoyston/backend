package com.manager.service;

import com.manager.pojo.User;

import java.util.List;

/**
 * @author XuBowen
 * @date 2021/11/13 12:23
 */
public interface UserService {

    // 校验用户登录
    User checkUserLoginService(String name,String pwd);

    // 修改用户密码
    int userChangePwdService(String newPwd, int uid);

    // 获取所有用户信息
    List<User> userShowService();

    // 用户注册
    int userRegService(User u);

}
