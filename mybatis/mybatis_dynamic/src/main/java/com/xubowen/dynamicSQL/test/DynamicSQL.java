package com.xubowen.dynamicSQL.test;

import com.xubowen.dynamicSQL.mapper.EmpMapper;
import com.xubowen.dynamicSQL.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author XuBowen
 * @date 2022/1/16 14:18
 */
public class DynamicSQL {
    @Test
    public void selectEmp() throws IOException {
        // 获取sqlSession对象
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // 开启自动事务提交
        SqlSession sqlSession = factory.openSession(true);

        // if标签
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emp = empMapper.selEmp("CLERK", 20, 1000);
        System.out.println(emp);

        // where标签
        emp = empMapper.selEmp2("CLERK", 20, 1000);
        System.out.println(emp);

        // 传参处理 bind标签
        emp = empMapper.selEmp3("CLERK");
        System.out.println(emp);

        // 动态增加信息
        Emp e = new Emp();
        e.setEmpno(8000);
        e.setEname("bbb");
        int res = empMapper.updateEmp(e);
        System.out.println(res);

        // 查询符合一个集合条件的参数
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(8000);
        list.add(9000);
        emp=empMapper.selEmp4(list);
        System.out.println(emp);
    }
}
