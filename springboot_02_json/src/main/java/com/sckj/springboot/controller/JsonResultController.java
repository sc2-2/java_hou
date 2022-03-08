package com.sckj.springboot.controller;

import com.sckj.springboot.entity.JsonResult;
import com.sckj.springboot.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jsonResult")
public class JsonResultController {

    @RequestMapping("/user")
    public JsonResult<User> getUser() {
        User user= new User(1, "倪升武", "123456");
        return new JsonResult<>(user);
    }

    @RequestMapping("/list")
    public JsonResult<List> getUserList(){
        List<User> userList = new ArrayList<>();
        User user1 = new User(1, null, "123456");
        User user2 = new User(2, "达人课", null);
        userList.add(user1);
        userList.add(user2);
        return new JsonResult<>(userList,"获取用户列表成功");
    }

    @RequestMapping("/map")
    public JsonResult<Map> getMap(){
        Map<String, Object> map = new HashMap<>(3);
        User user = new User(1, "王力勇", null);
        map.put("作者信息", user);
        map.put("博客地址", "http://blog.itcodai.com");
        //map.put("CSDN地址", "http://blog.csdn.net/eson_15");
        map.put("CSDN地址", null);
        map.put("粉丝数量", 4153);
        return new JsonResult<>(map);
    }
}
