package com.xubowen.staticproxy.pojo;

/**
 * @author XuBowen
 * @date 2022/2/9 22:33
 */
public class Student implements StudentInterface {
    @Override
    public String testStu(String name,Integer age) {
        //System.out.println(5/0);
        System.out.println("我是学生测试方法");
        return "spring";
    }
}
