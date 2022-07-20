package com.xubowen.multiquery.mapper;

import com.xubowen.multiquery.pojo.Dept;
import com.xubowen.multiquery.pojo.Emp;
import org.apache.ibatis.annotations.Param;


import java.util.ArrayList;
import java.util.List;

/**
 * @author XuBowen
 * @date 2022/1/12 21:01
 */
public interface EmpMapper {
    // 多对一查询，查询员工，顺便查出对应部门
    List<Emp> selEmpWithDept();

    // 一对多查询 查询部门，顺便查出部门下的所有员工
    List<Emp> selEmpByDeptno(@Param("deptno") Integer deptno);

}
