package aspectJ_annotation.pojo;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author XuBowen
 * @date 2022/2/9 22:33
 */

@Component
public class Student implements StudentInterface {

    @Override
    @Pointcut("execution(* aspectJ_annotation.pojo.Student.testStu())")
    public void testStu() {
        System.out.println("我是学生真实方法");
    }
}
