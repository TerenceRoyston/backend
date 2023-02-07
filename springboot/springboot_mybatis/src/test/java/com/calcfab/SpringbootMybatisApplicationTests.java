package com.calcfab;

import com.calcfab.domain.User;
import com.calcfab.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author XuBowen
 * @date 2023/2/5 16:32
 */
@SpringBootTest(classes = SpringbootMybatisApplicationTests.class)
public class SpringbootMybatisApplicationTests {
    @Resource
    private UserMapper userMapper;

    @Test
    void testFindAll() {
        List<User> res = userMapper.findAll();
        for (User user : res) {
            System.out.println(user);
        }
    }
}
