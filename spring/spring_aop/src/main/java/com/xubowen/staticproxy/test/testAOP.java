package com.xubowen.staticproxy.test;

import com.xubowen.staticproxy.pojo.StudentInterface;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author XuBowen
 * @date 2022/2/9 22:37
 */
public class testAOP {
    public static void main(String[] args) {
        // ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("file:F:\\ProgrammingSoftware\\IntelliJ IDEA Workspace\\backend\\spring\\spring_aop\\src\\main\\webapp\\WEB-INF\\classes\\applicationContext.xml");
        StudentInterface studentInterface= (StudentInterface) ac.getBean("stu");
        studentInterface.testStu("mike",20);
    }
}
