package com.xubowen.advice;

import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;


/**
 * @author XuBowen
 * @date 2022/2/15 22:43
 */
public class MyBefore implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        Logger logger = Logger.getLogger(MyBefore.class);
        logger.debug(objects[0]+"发起请求");
    }
}
