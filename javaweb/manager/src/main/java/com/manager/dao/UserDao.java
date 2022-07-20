package com.manager.dao;

import com.manager.pojo.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @author XuBowen
 * @date 2021/11/13 12:26
 */
public interface UserDao {
    // 根据用户名密码查询用户信息
    User checkUserLoginDao(String uname, String pwd) ;

    // 根据用户ID修改密码
    int userChangePwdDao(String newPwd, int uid);

    // 获取所有用户信息
    List<User> userShowDao();

    // 用户注册
    int userRegDao(User u);
}
