package aspectj.pojo;

/**
 * @author XuBowen
 * @date 2022/2/9 22:33
 */
public class Student implements StudentInterface {
    @Override
    public void testStu(String name,Integer age) {
        System.out.println("我是学生真实方法");
    }
}
