package com.calcfab.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.calcfab.dao.BookDao;
import com.calcfab.domain.Book;
import com.calcfab.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author XuBowen
 * @date 2023/2/11 13:15
 */

@Service
public class BookServiceImpl extends ServiceImpl<BookDao,Book> implements BookService {
}
