package com.xubowen.multiquery.mapper;

import com.xubowen.multiquery.pojo.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author XuBowen
 * @date 2022/1/19 22:23
 */
public interface DeptMapper {
    List<Dept> selDeptByDeptno(@Param("deptno") Integer deptno);

    List<Dept> selDeptWithEmp();
}
