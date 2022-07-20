package com.xubowen.advice;

import org.springframework.aop.ThrowsAdvice;

/**
 * @author XuBowen
 * @date 2022/2/11 22:42
 */
public class MyThrow implements ThrowsAdvice {
    public void afterThrowing(Exception e) throws Throwable{
        System.out.println("我是异常");
    }
}
