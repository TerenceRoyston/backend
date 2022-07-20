package com.xubowen.multiquery.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author XuBowen
 * @date 2022/1/16 22:44
 */

@Data
public class Dept {
    Integer deptno;
    String dname;
    String loc;

    List<Emp> empList;
}
