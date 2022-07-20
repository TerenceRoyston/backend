package aspectj.test;


import aspectj.pojo.StudentInterface;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author XuBowen
 * @date 2022/2/9 22:37
 */
public class testAOP {
    public static void main(String[] args) {
        // ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("file:F:\\ProgrammingSoftware\\IntelliJ IDEA Workspace\\backend\\spring\\spring_aop\\src\\main\\java\\aspectj\\cfg\\applicationContext.xml");
        StudentInterface studentInterface= (StudentInterface) ac.getBean("stu");
        studentInterface.testStu("mike",20);
    }
}
