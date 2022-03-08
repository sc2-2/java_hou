package com.sckj.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/sayHello")
    @ResponseBody
    public String sayHello(){
        return "欢迎来到Springboot学习世界";
    }
}
