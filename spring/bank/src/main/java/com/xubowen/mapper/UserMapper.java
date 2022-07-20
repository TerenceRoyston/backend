package com.xubowen.mapper;

import com.xubowen.staticproxy.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author XuBowen
 * @date 2022/2/13 16:23
 */
public interface UserMapper {
    // 用户登录

    @Select("select * from t_user where uname=#{uname} and pwd =#{pwd}")
    User userLoginMapper(@Param("uname") String uname, @Param("pwd") String pwd);
}
