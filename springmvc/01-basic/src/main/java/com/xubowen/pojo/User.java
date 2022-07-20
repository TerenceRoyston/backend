package com.xubowen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author XuBowen
 * @date 2022/2/23 22:53
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String uname;
    private Integer age;
}
