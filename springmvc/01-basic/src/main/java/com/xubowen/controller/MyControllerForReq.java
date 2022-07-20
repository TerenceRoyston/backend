package com.xubowen.controller;

import com.xubowen.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author XuBowen
 * @date 2022/2/22 23:16
 */

@Controller
public class MyControllerForReq {
    // 单元方法
    @RequestMapping("demo")
    public String demo() {
        System.out.println("我是demo方法");
        return "aa";
    }

    // 紧耦合方式获取请求数据
    @RequestMapping("demoReq")
    public String demoReq(HttpServletRequest request) {
        String uname = request.getParameter("uname");
        int age = Integer.parseInt(request.getParameter("age"));
        System.out.println("紧耦合 => " + uname + " : " + age);
        return "aa";
    }

    // 解耦合方式获取请求数据
    @RequestMapping("getDataByArgName")
    public String getDataByArgName(String uname, int age) {
        // 从req中接受的参数是String类型，所以如果形参为int会强转，如果请求中没有age参数则会报错
        // 所以建议写成包装类Integer
        System.out.println("解耦合 => " + uname + " : " + age);
        return "aa";
    }

    // 形参名与请求键名不一致的情况
    @RequestMapping("getDataByReqParam")
    public String getDataByReqParam(@RequestParam("uname") String uname, @RequestParam("age") Integer ageAge) {
        System.out.println("形参名与请求键名不一致 => " + uname + " : " + ageAge);
        return "aa";
    }

    // 使用实体类接收请求参数
    @RequestMapping("getDataByObject")
    public String getDataByObject(User user) {
        System.out.println("实体类接收请求参数" + user);
        return "aa";
    }

    // 同键不同值情况
    @RequestMapping("getDataByValues")
    public String getDataByValues(String uname, Integer age,String[] favs){
        System.out.println("同键不同值情况" + favs[0]+" => "+favs[1]);
        return "aa";
    }

    // restful格式
    @RequestMapping("aa/{bb}/{cc}")
    public String testRestful(@PathVariable("bb") String uname,@PathVariable("cc") Integer age){
        System.out.println("我是公共方法"+uname +" => "+age);
        return "kk/sa/dasda/xdasd";
    }
}
