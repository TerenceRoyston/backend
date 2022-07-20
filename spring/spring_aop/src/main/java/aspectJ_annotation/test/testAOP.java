package aspectJ_annotation.test;



import aspectJ_annotation.pojo.StudentInterface;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author XuBowen
 * @date 2022/2/9 22:37
 */
public class testAOP {
    public static void main(String[] args) {
        // ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("file:F:\\ProgrammingSoftware\\IntelliJ IDEA Workspace\\backend\\spring\\spring_aop\\src\\main\\java\\aspectJ_annotation\\cfg\\applicationContext.xml");
        StudentInterface studentInterface= (StudentInterface) ac.getBean("student");
        studentInterface.testStu();
    }
}
