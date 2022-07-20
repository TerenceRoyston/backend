package com.xubowen.dynamic.jdk.test;

import com.xubowen.dynamic.jdk.myjdk.MyJDK;
import com.xubowen.dynamic.jdk.pojo.MyInterface;

import java.lang.reflect.Proxy;

/**
 * @author XuBowen
 * @date 2022/2/17 22:33
 */
public class TestJDK {
    public static void main(String[] args) {
        // 获取代理对象
        MyInterface o = (MyInterface) Proxy.newProxyInstance(TestJDK.class.getClassLoader(), new Class[]{MyInterface.class}, new MyJDK());
        o.testMethod("jack");
    }
}
