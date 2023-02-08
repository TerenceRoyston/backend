package com.calcfab.dao.daoimpl;

import com.calcfab.dao.BookDao;
import org.springframework.stereotype.Repository;

/**
 * @author XuBowen
 * @date 2023/2/7 21:41
 */
@Repository
public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("book dao ok");
    }
}
