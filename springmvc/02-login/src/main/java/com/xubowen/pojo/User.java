package com.xubowen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author XuBowen
 * @date 2022/2/25 20:10
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer uid;
    private String uname;
    private String pwd;
    private String phone;

}
