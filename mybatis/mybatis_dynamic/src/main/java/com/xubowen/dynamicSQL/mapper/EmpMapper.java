package com.xubowen.dynamicSQL.mapper;

import com.xubowen.dynamicSQL.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XuBowen
 * @date 2022/1/12 21:01
 */
public interface EmpMapper {
    // if标签 根据不同条件查询员工
    List<Emp> selEmp(@Param("job") String job,@Param("deptno") Integer deptno,@Param("sal") Integer sal);

    // where标签 根据不同条件查询员工
    List<Emp> selEmp2(@Param("job") String job,@Param("deptno") Integer deptno,@Param("sal") Integer sal);

    // 传参处理 bind标签
    List<Emp> selEmp3(@Param("job") String job);

    // set标签 数据更新中多条件问题以及把有属性的字段被覆盖为空值问题
    int updateEmp(@Param("e") Emp emp);

    // foreach标签
    List<Emp> selEmp4(@Param("ids") ArrayList ids);

}
