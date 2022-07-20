package com.xubowen.factory;

import com.xubowen.staticproxy.pojo.Student;

/**
 * @author XuBowen
 * @date 2022/1/27 22:49
 */
public class StudentFactory2 {
    public static Student newInstance(){
        Student student = new Student();
        student.setName("jess_static");
        return student;
    }
}
