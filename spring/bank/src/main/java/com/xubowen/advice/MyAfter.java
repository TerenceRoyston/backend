package com.xubowen.advice;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author XuBowen
 * @date 2022/2/15 22:45
 */
public class MyAfter implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        if (o!=null){
            Logger logger = Logger.getLogger(MyAfter.class);
            logger.debug(objects[0]+"登陆成功");
        }
    }
}
