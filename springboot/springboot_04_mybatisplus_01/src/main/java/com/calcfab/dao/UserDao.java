package com.calcfab.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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

@Repository
@Mapper
public interface UserDao extends BaseMapper<User> {
}
