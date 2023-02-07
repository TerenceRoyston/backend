package com.xubowen.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author XuBowen
 * @date 2022/3/9 23:14
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
// 读控制文件application.yml里的配置
@ConfigurationProperties(prefix = "foo.user")
public class User {
    private String name;
    private Integer id;
}
