package com.calcfab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XuBowen
 * @date 2023/2/5 20:11
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @Value("${school}")
    private String school;

    @Autowired
    private Environment env;

    @GetMapping
    public String getById(){
        System.out.println("springboot is running");
        System.out.println(school);
        System.out.println(env.getProperty("company"));
        return "springboot is running";
    }


}
