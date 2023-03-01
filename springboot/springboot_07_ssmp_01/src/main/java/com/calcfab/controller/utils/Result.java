package com.calcfab.controller.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author XuBowen
 * @date 2023/2/11 22:52
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result {
    private Boolean flag;
    private Object data;
    private String msg;

    public Result(Boolean flag) {
        this.flag = flag;
    }

    public Result(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }
}
