package com.sckj.springboot.controller;

import com.sckj.springboot.entity.User;
import com.sckj.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUserByName/{name}")
    public User getUserByName(@PathVariable String name){
        return userService.getUserByName(name);
    }

    @RequestMapping("/getUser/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUser(id);
    }
}
