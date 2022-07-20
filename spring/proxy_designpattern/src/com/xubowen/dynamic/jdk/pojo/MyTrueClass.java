package com.xubowen.dynamic.jdk.pojo;

/**
 * @author XuBowen
 * @date 2022/2/17 22:32
 */
public class MyTrueClass implements MyInterface {
    @Override
    public void testMethod(String name) {
        System.out.println("我是jdk动态代理 => "+name);
    }
}
