package com.xubowen.service.impl;

import com.xubowen.mapper.UserMapper;
import com.xubowen.staticproxy.pojo.User;
import com.xubowen.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author XuBowen
 * @date 2022/2/7 21:59
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserMapper um;

    @Override
    public User userLoginService(String uname, String pwd) {

        User user = um.userLoginMapper(uname, pwd);
        return user;
    }
}
