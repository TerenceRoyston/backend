package com.xubowen.service.impl;

import com.xubowen.mapper.UserMapper;
import com.xubowen.staticproxy.pojo.User;
import com.xubowen.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author XuBowen
 * @date 2022/2/13 20:53
 */

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Override
    public User userLoginService(String uname, String pwd) {
        User user = userMapper.userLoginMapper(uname, pwd);
        return user;
    }
}
