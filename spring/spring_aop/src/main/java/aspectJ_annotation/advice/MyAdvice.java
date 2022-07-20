package aspectJ_annotation.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author XuBowen
 * @date 2022/2/12 19:20
 */
@Component
@Aspect
public class MyAdvice {
    // 前置方法
    @Before("aspectJ_annotation.pojo.Student.testStu()")
    public void before() {
        System.out.println("前置通知");
    }

    @After("aspectJ_annotation.pojo.Student.testStu()")
    // 后置方法
    public void after() {
        System.out.println("后置通知");
    }

    // 环绕方法
    @Around("aspectJ_annotation.pojo.Student.testStu()")
    public Object round(ProceedingJoinPoint pp) throws Throwable {
        System.out.println("环绕前");
        pp.proceed();
        System.out.println("环绕后");
        return pp;
    }

    // 声明异常方法
    @AfterThrowing("aspectJ_annotation.pojo.Student.testStu()")
    public void myThrow() {
        System.out.println("我是异常");
    }

}
