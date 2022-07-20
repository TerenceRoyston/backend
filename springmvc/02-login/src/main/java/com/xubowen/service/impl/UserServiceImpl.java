package com.xubowen.service.impl;

import com.xubowen.mapper.UserMapper;
import com.xubowen.pojo.User;
import com.xubowen.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author XuBowen
 * @date 2022/2/26 13:28
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Controller
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User selUserInfoService(String uname, String pwd) {
         return userMapper.selUserInfoMapper(uname,pwd);
    }
}
