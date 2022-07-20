package com.xubowen.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author XuBowen
 * @date 2022/2/11 22:29
 */
public class MyRound implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {


        // 环绕前
        System.out.println("环绕前");
        // 放行
        Object proceed = methodInvocation.proceed();

        // 环绕后
        System.out.println("环绕后");
        return proceed;

    }
}
