package com.manager.service.impl;

import com.manager.dao.UserDao;
import com.manager.dao.impl.UserDaoImpl;
import com.manager.pojo.User;
import com.manager.service.UserService;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * @author XuBowen
 * @date 2021/11/13 12:25
 */
public class UserServiceImpl implements UserService {
    // 声明日志对象
    Logger logger = Logger.getLogger(UserServiceImpl.class);
    // 声明Dao层对象
    UserDao ud = new UserDaoImpl();

    // 用户登录
    @Override
    public User checkUserLoginService(String uname, String pwd) {
        // 打印日志
        logger.debug(uname + " => 发起登录请求");
        User u = ud.checkUserLoginDao(uname, pwd);
        if (u != null) {
            logger.debug(uname + "登录成功");
        } else {
            logger.debug(uname + "登录失败");
        }
        return u;
    }

    @Override
    public int userChangePwdService(String newPwd, int uid) {
        // 打印日志
        logger.debug(uid + " => 发起密码修改请求");
        int index=ud.userChangePwdDao(newPwd, uid);
        if (index > 0){
            logger.debug(uid + " => 密码修改成功");
        }else {
            logger.debug(uid + " => 密码修改失败");
        }
        return index;
    }


    @Override
    public List<User> userShowService() {
        List<User> lu =ud.userShowDao();
        // 打印日志
        logger.debug(" => 显示所有用户信息" + lu);
        return lu;
    }

    @Override
    public int userRegService(User u) {
        return ud.userRegDao(u);
    }
}
