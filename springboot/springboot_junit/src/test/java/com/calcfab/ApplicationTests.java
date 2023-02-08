package com.calcfab;

import com.calcfab.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
	@Autowired
	private BookDao bookDao;

	@Test
	void contextLoads() {
		System.out.println("ok");
		bookDao.save();
	}

}
