package com.xubowen.mybatis;

import com.xubowen.mybatis.interface_mapper.EmpMapper;
import com.xubowen.mybatis.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * @author XuBowen
 * @date 2022/1/9 20:35
 */
public class MybatisTest {

    /**
     * 使用官方方式操作Dao层
     * @throws IOException
     */
    @Test
    public void getInfo() throws IOException {

        // 获取sqlSession对象
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();

        // 使用SqlSession对象完成数据库操作
        List<Object> objects = sqlSession.selectList("com.xubowen.mybatis.mapper.EmpMapper.select_emp");
        System.out.println(objects);

        // 单参数查询
        Emp emp = sqlSession.selectOne("com.xubowen.mybatis.mapper.EmpMapper.selEmpById", 7566);
        System.out.println(emp);

        // 多参数查询
        // 使用map封装实参
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("a",800);
        map.put("b",30);
        List<Emp> emps=sqlSession.selectList("com.xubowen.mybatis.mapper.EmpMapper.selEmpBySalAndDeptno",map);
        System.out.println(emps);


    }

    @Test
    public void insertInfo() throws IOException {
        // 获取sqlSession对象
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();

        // 使用SqlSession对象完成数据库操作
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("empno",8001);
        map.put("ename","messy");
        map.put("job","boss");
        map.put("mgr",8000);
        map.put("hiredate","2022-01-01");
        map.put("sal",50000);
        map.put("comm",50000);
        map.put("deptno",101);
        sqlSession.insert("com.xubowen.mybatis.mapper.EmpMapper.insertEmp",map);

        // 强制手动提交
        sqlSession.commit();
    }

    @Test
    public void updateInfo() throws IOException {
        // 获取sqlSession对象
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();

        // 使用SqlSession对象完成数据库操作
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("empno",8001);
        map.put("ename","jessie");

        sqlSession.update("com.xubowen.mybatis.mapper.EmpMapper.updateEmp",map);

        // 强制手动提交
        sqlSession.commit();
    }

    @Test
    public void deleteInfo() throws IOException {
        // 获取sqlSession对象
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();

        // 使用SqlSession对象完成数据库操作
        sqlSession.delete("com.xubowen.mybatis.mapper.EmpMapper.deleteEmp",8001);

        // 强制手动提交
        sqlSession.commit();
    }


    /**
     * 使用自定义接口的方式操作Dao层
     * @throws IOException
     */
    @Test
    public void getInfoWithInterface() throws IOException {
        // 获取sqlSession对象
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();

        // 获取Mapper接口实现类
        // 无参数查询
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emps = empMapper.selEmpWithInterface();
        System.out.println(emps);

        emps=empMapper.selEmpByIncludeWithInterface();
        System.out.println(emps);

        // 单参数查询  传入基本类型
        Emp emp = empMapper.selEmpByIdWithInterface(7521);
        System.out.println(emp);


        // 单参数查询  传入引用类型
        Emp e = new Emp();
        e.setEmpno(7369);
        emp = empMapper.selEmpByIdWithInterface2(e);
        System.out.println(emp);

        // 多参数查询
        // 传入多个基本类型
        emps = empMapper.selEmpBySalAndDeptnoWithInterface(800.0,20);
        System.out.println(emps);

        // 传入多个引用类型
        Emp e1 = new Emp();
        Emp e2 = new Emp();
        e1.setSal(800.0);
        e2.setDeptno(20);
        emps = empMapper.selEmpBySalAndDeptnoWithInterface2(e1,e2);
        System.out.println(emps);

        emps = empMapper.selEmpBySalAndDeptnoWithInterface3(e1,e2);
        System.out.println(emps);

        // 引用查询
        emp=empMapper.selEmpByFuzzyQueryWithInterface("smit");
        System.out.println(emp);

    }



}
