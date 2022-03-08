package com.sckj.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConfigController {

    @Value("${person.last-name}")
    private String name;
    @Value("${person.age}")
    private Integer age;

    //数组格式的绑定
    @Value("${city.cityList}")
    private String[] cityList;

    //集合格式的绑定
    @Value(value = "#{person.lists}")
    private List<String> lists;

    @RequestMapping("/sayName")
    public String sayName(){
        return "hello"+name+"你的年龄是"+age;
    }

    @RequestMapping("/sayHello")
    public String sayHello(){
        return "hello\t"+cityList[0]+"\t"+cityList[1]+"\t"+cityList[2];
    }

    @RequestMapping("/sayList")
    public List<String> sayList(){
        return lists;
    }

    //属性配置
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
}
