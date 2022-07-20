package com.xubowen.staticproxy.test;

import com.xubowen.staticproxy.pojo.MyProxyStatic;

/**
 * @author XuBowen
 * @date 2022/2/16 22:53
 */
public class Test {
    public static void main(String[] args) {
        MyProxyStatic proxyStatic = new MyProxyStatic();
        proxyStatic.testProxyMethod();
    }
}
