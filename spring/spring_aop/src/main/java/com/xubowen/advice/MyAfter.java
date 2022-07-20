package com.xubowen.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author XuBowen
 * @date 2022/2/10 22:17
 */
public class MyAfter implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("我是后置通知方法");
        // 参数o为扩展方法返回值
        System.out.println(o);
    }
}
