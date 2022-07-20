package com.xubowen.loginexercise.dao;


import com.xubowen.loginexercise.pojo.User;

/**
 * @author XuBowen
 * @date 2021/9/15 23:11
 */
public interface LoginDao {
	//根据用户名和密码获取用户信息
	User checkLoginDao(String username, String password) throws ClassNotFoundException, Exception;

	// 根据id获取用户信息
	User checkIdDao(String id) throws Exception;
}
