package com.xubowen.annotation.test;

import com.xubowen.annotation.mapper.EmpMapper;
import com.xubowen.annotation.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author XuBowen
 * @date 2022/1/20 23:31
 */
public class AnnotationSQL {

    @Test
    public void selEmp() throws IOException {
        // 获取sqlSession对象
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // 开启自动事务提交
        SqlSession sqlSession = factory.openSession(true);

        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emps = empMapper.selEmp();
        System.out.println(emps);

        Emp emp = empMapper.selEmpByIdMapper(7654);
        System.out.println(emp);
    }
}
