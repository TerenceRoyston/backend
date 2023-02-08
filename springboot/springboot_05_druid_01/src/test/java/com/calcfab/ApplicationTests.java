package com.calcfab;

import com.calcfab.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {
	@Autowired
	private UserDao userDao;

	@Test
	void contextLoads() {
		System.out.println(userDao.findAll());
	}

}
