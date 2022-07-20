package com.xubowen.mybatis.interface_mapper;

import com.xubowen.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author XuBowen
 * @date 2022/1/12 21:01
 */
public interface EmpMapper {
    // 查询所有员工信息
    List<Emp> selEmpWithInterface();

    // 单参数  根据ID查员工信息  传入基本类型
    Emp selEmpByIdWithInterface(int empno);

    // 单参数  根据ID查员工信息  传入引用类型
    Emp selEmpByIdWithInterface2(Emp emp);

    // 多参数
    List<Emp> selEmpBySalAndDeptnoWithInterface(double sal,int deptno);
    List<Emp> selEmpBySalAndDeptnoWithInterface2(Emp e1,Emp e2);
    List<Emp> selEmpBySalAndDeptnoWithInterface3(@Param("e1") Emp e1, @Param("e2") Emp e2);

    // 封装SQL片段
    List<Emp> selEmpByIncludeWithInterface();

    // 模糊查询
    Emp selEmpByFuzzyQueryWithInterface(String ename);
}
