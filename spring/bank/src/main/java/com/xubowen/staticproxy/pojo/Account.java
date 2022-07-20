package com.xubowen.staticproxy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author XuBowen
 * @date 2022/2/13 15:53
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Integer aid;
    private String apwd;
    private Double money;
    private Integer uid;

}
