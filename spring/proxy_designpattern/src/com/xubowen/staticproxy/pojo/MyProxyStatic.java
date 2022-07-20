package com.xubowen.staticproxy.pojo;

/**
 * @author XuBowen
 * @date 2022/2/16 22:50
 */
public class MyProxyStatic {
    public void testProxyMethod(){
        System.out.println("我是代理方法");
        MyTrueClass trueClass = new MyTrueClass();
        trueClass.testTrueMethod();
    }
}
