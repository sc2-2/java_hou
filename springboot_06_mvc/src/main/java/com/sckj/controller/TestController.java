package com.sckj.controller;

import com.sckj.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test",produces = "application/json; charset=UTF-8")
public class TestController {


    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public String testGet(){
        return "success";
    }

    @GetMapping("/user/{id}")
    public String testPathVariable(@PathVariable Integer id){
        System.out.println("你的ID为"+id);
        return "success";
    }

    @RequestMapping("/user/{idd}")
    public String testPathIdVariable(@PathVariable(value = "idd") Integer id) {
        System.out.println("获取到的id为：" + id);
        return "success";
    }

    @GetMapping("/user/{idd}/{name}")
    public String testPathTwoVariable(@PathVariable(value = "idd") Integer id,@PathVariable String name) {
        System.out.println("获取到的id为:" + id);
        System.out.println("获取到的name为:"+name);
        return "success";
    }

    @GetMapping("/user")
    public String testRequestParam(@RequestParam Integer id) {
        System.out.println("获取到的id为：" + id);
        return "success";
    }

    @PostMapping("/form1")
    public String testForm(@RequestParam String username, @RequestParam String
            password) {
        System.out.println("获取到的username为：" + username);
        System.out.println("获取到的password为：" + password);
        return "success";
    }

    @PostMapping("/form2")
    public String testForm(User user) {
        System.out.println("获取到的username为：" + user.getUsername());
        System.out.println("获取到的password为：" + user.getPassword());
        return "success";
    }

    @PostMapping("/user")
    public String testRequestBody(@RequestBody User user) {
        System.out.println("获取到的username为：" + user.getUsername());
        System.out.println("获取到的password为：" + user.getPassword());
        return "success";
    }
}
