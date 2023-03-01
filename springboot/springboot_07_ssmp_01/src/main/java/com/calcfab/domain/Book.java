package com.calcfab.domain;

import lombok.Data;

/**
 * @author XuBowen
 * @date 2023/2/10 23:08
 */
@Data
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;
}
