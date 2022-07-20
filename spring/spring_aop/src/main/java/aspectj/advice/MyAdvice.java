package aspectj.advice;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author XuBowen
 * @date 2022/2/12 19:20
 */
public class MyAdvice {
    // 前置方法
    public void before(String name,Integer age){
        System.out.println("前置通知");
        System.out.println("前置方法取到参数 => "+name);
    }

    // 后置方法
    public void after(){
        System.out.println("后置通知");
    }

    // 环绕方法
    public Object round(ProceedingJoinPoint pp) throws Throwable {
        System.out.println("环绕前");
        pp.proceed();
        System.out.println("环绕后");
        return pp;
    }

    // 声明异常方法
    public void myThrow(){
        System.out.println("我是异常");
    }

}
