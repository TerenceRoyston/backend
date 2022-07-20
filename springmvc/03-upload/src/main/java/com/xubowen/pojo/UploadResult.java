package com.xubowen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author XuBowen
 * @date 2022/2/27 17:53
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UploadResult {
    private Boolean state;
    private String msg;
    private String url;
}
