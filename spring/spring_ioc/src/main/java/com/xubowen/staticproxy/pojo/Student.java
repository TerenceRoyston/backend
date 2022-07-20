package com.xubowen.staticproxy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author XuBowen
 * @date 2022/1/23 22:52
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    Integer id;
    String name;
    Integer age;
    Teacher teacher;
}
