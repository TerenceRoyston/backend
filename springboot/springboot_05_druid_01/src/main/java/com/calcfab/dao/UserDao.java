package com.calcfab.dao;

import com.calcfab.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author XuBowen
 * @date 2023/2/5 0:44
 */

@Mapper
@Repository
public interface UserDao {
    @Select("select * from t_user")
    List<User> findAll();
}
