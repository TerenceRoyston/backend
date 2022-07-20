package com.xubowen.mybatis.pojo;

import lombok.Data;

/**
 * @author XuBowen
 * @date 2022/1/9 21:09
 */

@Data
public class Emp {
    private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;
    private String hiredate;
    private Double sal;
    private Double comm;
    private Integer deptno;

}
