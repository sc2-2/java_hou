package com.sckj.springboot.controller;

import com.sckj.springboot.entity.User;
import com.sckj.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user)throws Exception{
        if(user!=null){
            userService.insertUser(user);
            return "success";
        }else {
            return "false";
        }
    }

    @PostMapping("/addUser2")
    public String addUser2(@RequestBody User user)throws Exception{
        if(user!=null){
            userService.insertUser2(user);
            return "success";
        }else {
            return "false";
        }
    }

    @PostMapping("/addUser3")
    public String addUser3(@RequestBody User user)throws Exception{
        if(user!=null){
            userService.insertUser3(user);
            return "success";
        }else {
            return "false";
        }
    }

    @PostMapping("/addUser4")
    public String addUser4(@RequestBody User user)throws Exception{
        if(user!=null){
            userService.insertUser4(user);
            return "success";
        }else {
            return "false";
        }
    }
}
