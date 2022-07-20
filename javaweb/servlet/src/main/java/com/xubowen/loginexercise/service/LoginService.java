package com.xubowen.loginexercise.service;

import com.xubowen.loginexercise.pojo.User;

/**
 * @author XuBowen
 * @date 2021/10/31 22:49
 */
public interface LoginService {
	// 校验用户登录信息
	User checkLoginService(String username, String password) throws Exception;

	// 校验用户Cookie信息
	User checkLoginService(String id) throws Exception;
}
