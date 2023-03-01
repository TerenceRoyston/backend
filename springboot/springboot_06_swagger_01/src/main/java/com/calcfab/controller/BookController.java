package com.calcfab.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * @author XuBowen
 * @date 2023/2/5 20:11
 */
@RestController
@RequestMapping("/books")
@Api(tags = {"书接口"},description = "书书书")
public class BookController {

    @PostMapping
    public String getById(@RequestParam("name") String name){
        System.out.println("springboot is running");
        //return "springboot is running";
        return name;
    }
}
