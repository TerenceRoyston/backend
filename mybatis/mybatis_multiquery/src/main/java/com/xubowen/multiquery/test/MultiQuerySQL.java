package com.xubowen.multiquery.test;


import com.xubowen.multiquery.mapper.DeptMapper;
import com.xubowen.multiquery.mapper.EmpMapper;
import com.xubowen.multiquery.pojo.Dept;
import com.xubowen.multiquery.pojo.Emp;
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
 * @date 2022/1/16 14:18
 */
public class MultiQuerySQL {

    @Test
    public void selDeptByDeptno() throws IOException {
        // 获取sqlSession对象
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // 开启自动事务提交
        SqlSession sqlSession = factory.openSession(true);

        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        List<Dept> depts = deptMapper.selDeptByDeptno(20);
        System.out.println(depts);

        List<Emp> emps = empMapper.selEmpWithDept();
        System.out.println(emps);

        depts=deptMapper.selDeptWithEmp();
        System.out.println(depts);

    }
}

