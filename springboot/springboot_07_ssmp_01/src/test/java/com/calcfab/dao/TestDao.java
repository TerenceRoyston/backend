package com.calcfab.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author XuBowen
 * @date 2023/2/11 0:01
 */

@SpringBootTest
public class TestDao {
    @Autowired
    BookDao bookDao;

    @Test
    void test_getBookById(){
        System.out.println(bookDao.selectById(1));
    }
}
