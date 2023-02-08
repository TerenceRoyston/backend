package com.calcfab.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author XuBowen
 * @date 2023/2/5 0:28
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private int uid;
    private String uname;
    private String pwd;
}
