package com.xubowen.dynamic.jdk.myjdk;

import com.xubowen.dynamic.jdk.pojo.MyTrueClass;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author XuBowen
 * @date 2022/2/17 22:43
 */
public class MyJDK implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是扩展代码");
        MyTrueClass myTrueClass = new MyTrueClass();
        myTrueClass.testMethod((String) args[0]);
        return null;
    }
}
