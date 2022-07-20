package com.xubowen.mapper;

import com.xubowen.staticproxy.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author XuBowen
 * @date 2022/2/7 21:52
 */
public interface UserMapper {
    @Select("select * from t_user where uname=#{uname} and pwd=#{pwd}")
    User userLoginMapper(@Param("uname") String uname, @Param("pwd") String pwd);
}
