package com.xubowen.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author XuBowen
 * @date 2022/2/9 22:55
 */
public class MyBefore implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        // method是要扩展的方法，objects是代理对象的传参，o是真实对象
        System.out.println(objects[0]+" => "+objects[1]);
        //method.invoke(o,objects);
        System.out.println("我是前置通知方法");
    }
}
