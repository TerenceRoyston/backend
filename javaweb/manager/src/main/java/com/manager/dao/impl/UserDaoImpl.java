package com.manager.dao.impl;

import com.manager.dao.UserDao;
import com.manager.pojo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author XuBowen
 * @date 2021/11/13 12:28
 */
public class UserDaoImpl implements UserDao {


    // 根据用户名密码查询信息
    @Override
    public User checkUserLoginDao(String uname, String pwd) {
        // 声明jdbc对象
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        // 声明数据存储驱动
        User u = null;
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test01", "root", "0000");
            // 创建SQL语句
            String sql = "select * from t_user where uname=? and pwd=? ";
            // 创建SQL命令对象
            ps = conn.prepareStatement(sql);
            // 给占位符赋值
            ps.setString(1, uname);
            ps.setString(2, pwd);
            // 执行
            rs = ps.executeQuery();
            // 遍历执行结果
            while (rs.next()) {
                u = new User();
                u.setUid(rs.getInt("uid"));
                u.setUname(rs.getString("uname"));
                u.setPwd(rs.getString("pwd"));
                u.setSex(rs.getString("sex"));
                u.setAge(rs.getInt("age"));
                u.setBirth(rs.getString("birth"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return u;

    }

    //根据用户ID修改用户密码
    @Override
    public int userChangePwdDao(String newPwd, int uid) {
        // 声明jdbc对象
        Connection conn = null;
        PreparedStatement ps = null;
        // 声明返回值
        int index = -1;
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test01", "root", "0000");
            // 创建SQL语句
            String sql = "update t_user set pwd=? where uid=?";
            // 创建SQL命令对象
            ps = conn.prepareStatement(sql);
            // 给占位符赋值
            ps.setString(1, newPwd);
            ps.setInt(2, uid);

            // 执行
            index = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return index;
    }

    @Override
    public List<User> userShowDao() {
        // 声明jdbc对象
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        // 声明数据存储驱动
        List<User> lu = null;
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test01", "root", "0000");
            // 创建SQL语句
            String sql = "select * from t_user";
            // 创建SQL命令对象
            ps = conn.prepareStatement(sql);
            // 执行
            rs = ps.executeQuery();
            lu =new ArrayList<User>();
            // 遍历执行结果
            while (rs.next()) {
                User u = new User();
                u.setUid(rs.getInt("uid"));
                u.setUname(rs.getString("uname"));
                u.setPwd(rs.getString("pwd"));
                u.setSex(rs.getString("sex"));
                u.setAge(rs.getInt("age"));
                u.setBirth(rs.getString("birth"));
                // 将对象存储到集合中
                lu.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lu;
    }

    // 用户注册
    @Override
    public int userRegDao(User u) {
        // 声明jdbc对象
        Connection conn = null;
        PreparedStatement ps = null;
        // 声明返回值
        int index = -1;
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test01", "root", "0000");
            // 创建SQL语句
            String sql = "insert into t_user values(default,?,?,?,?,?)";
            // 创建SQL命令对象
            ps = conn.prepareStatement(sql);
            // 给占位符赋值
            ps.setString(1, u.getUname());
            ps.setString(2, u.getPwd());
            ps.setString(3, u.getSex());
            ps.setInt(4, u.getAge());
            ps.setString(5, u.getBirth());

            // 执行
            index = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return index;
    }
}
