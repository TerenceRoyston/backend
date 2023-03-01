package com.calcfab.service.impl;

import com.calcfab.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author XuBowen
 * @date 2023/2/11 13:26
 */
@SpringBootTest
class BookServiceImplTest {
    @Autowired
    BookService bookService;

    @Test
    void test_getAll(){
        System.out.println(bookService.list());
    }
}