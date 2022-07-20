package com.xubowen.loginexercise.dao.impl;



import com.xubowen.loginexercise.dao.LoginDao;
import com.xubowen.loginexercise.pojo.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author XuBowen
 * @date 2021/9/15 23:13
 */
public class LoginDaoImpl  implements LoginDao {
	@Override
	public User checkLoginDao(String username, String password) throws Exception {
		// 声明jdbc对象
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;

		// 声明数据存储驱动
		User user=null;
		try {
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 获取连接对象
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test00","root","0000");
			// 创建SQL语句
			String sql="select * from user_servlet where name=? and password=? ";
			// 创建SQL命令对象
			ps=conn.prepareStatement(sql);
			// 给占位符赋值
			ps.setString(1,username);
			ps.setString(2,password);
			// 执行
			rs=ps.executeQuery();
			// 遍历执行结果
			while (rs.next()){
				user=new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));

			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			rs.close();
			ps.close();
			conn.close();
		}
		return user;

	}

	@Override
	public User checkIdDao(String id) throws Exception{
		// 声明jdbc对象
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;

		// 声明数据存储驱动
		User user=null;
		try {
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 获取连接对象
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test00","root","0000");
			// 创建SQL语句
			String sql="select * from user_servlet where id=? ";
			// 创建SQL命令对象
			ps=conn.prepareStatement(sql);
			// 给占位符赋值
			ps.setString(1,id);
			// 执行
			rs=ps.executeQuery();
			// 遍历执行结果
			while (rs.next()){
				user=new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));

			}
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			rs.close();
			ps.close();
			conn.close();
		}
		return user;
	}
}
