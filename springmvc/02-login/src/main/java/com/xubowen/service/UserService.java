package com.xubowen.service;

import com.xubowen.pojo.User;

/**
 * @author XuBowen
 * @date 2022/2/26 13:19
 */
public interface UserService {
    User selUserInfoService(String uname, String pwd);
}
