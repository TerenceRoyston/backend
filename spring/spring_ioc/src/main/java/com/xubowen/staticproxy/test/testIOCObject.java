package com.xubowen.staticproxy.test;

import com.xubowen.staticproxy.pojo.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author XuBowen
 * @date 2022/1/23 22:55
 */
public class testIOCObject {
    public static void main(String[] args) {

        //ApplicationContext ac = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/classes/applicationContext.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("file:F:\\ProgrammingSoftware\\IntelliJ IDEA Workspace\\backend\\spring\\spring_ioc\\src\\main\\webapp\\WEB-INF\\classes\\applicationContext.xml");

        // 无参构造
        Student stu = (Student) ac.getBean("stu");
        System.out.println(stu);

        // 有参构造
        stu = (Student) ac.getBean("stu2");
        System.out.println(stu);

        // 属性注入
        stu = (Student) ac.getBean("stu3");
        System.out.println(stu);

        // 动态工厂创建
        stu = (Student) ac.getBean("stu4");
        System.out.println(stu);

        // 静态工厂创建
        stu = (Student) ac.getBean("stu5");
        System.out.println(stu);

        // DI 依赖注入
        // 1. 有参数构造
        stu = (Student) ac.getBean("stu6");
        System.out.println("stu6 => "+stu);

        // 2. 属性注入
        stu = (Student) ac.getBean("stu7");
        System.out.println("stu7 => "+stu);

        // 3. 自动注入
        stu = (Student) ac.getBean("stu8");
        System.out.println("stu8 => "+stu);

    }


}
