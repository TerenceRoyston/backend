package com.calcfab;

import com.calcfab.domain.User;
import com.calcfab.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

/**
 * @author XuBowen
 * @date 2023/2/5 13:07
 */
@SpringBootApplication
public class TestMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(TestMain.class, args);
        System.out.println(ctx.getBean(UserMapper.class));
    }
}
