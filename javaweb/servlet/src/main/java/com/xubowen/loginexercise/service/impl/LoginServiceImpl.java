package com.xubowen.loginexercise.service.impl;


import com.xubowen.loginexercise.dao.LoginDao;
import com.xubowen.loginexercise.dao.impl.LoginDaoImpl;
import com.xubowen.loginexercise.pojo.User;
import com.xubowen.loginexercise.service.LoginService;

/**
 * @author XuBowen
 * @date 2021/9/15 7:42
 */
public class LoginServiceImpl implements LoginService {
	LoginDao ld=new LoginDaoImpl();

	@Override
	public User checkLoginService(String username, String password) throws Exception {
		User user = ld.checkLoginDao(username, password);
		return user;
	}

	@Override
	public User checkLoginService(String id) throws Exception{
		return ld.checkIdDao(id);
	}
}
