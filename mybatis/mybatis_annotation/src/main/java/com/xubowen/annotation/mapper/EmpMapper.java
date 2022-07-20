package com.xubowen.annotation.mapper;

import com.xubowen.annotation.pojo.Emp;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author XuBowen
 * @date 2022/1/20 23:29
 */
public interface EmpMapper {

    // 查询所有员工
    @Select("select * from emp")
    List<Emp> selEmp();

    // 根据id查询员工
    @Select("select * from emp where empno = #{empid}")
    Emp selEmpByIdMapper(@Param("empid") Integer empid);

    // 其他操作省略
}
