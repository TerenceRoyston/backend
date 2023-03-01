package com.calcfab.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.calcfab.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author XuBowen
 * @date 2023/2/10 23:15
 */

@Mapper
@Repository
public interface BookDao extends BaseMapper<Book> {
}
