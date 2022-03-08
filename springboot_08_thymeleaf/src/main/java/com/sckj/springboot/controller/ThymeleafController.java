package com.sckj.springboot.controller;

import com.sckj.springboot.entity.Blogger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @RequestMapping("/test404")
    public String test404(){
        return "index";
    }

    @GetMapping("/getBlogger")
    public String getBlogger(Model model){
        Blogger blogger=new Blogger(1L,"李杰","admin");
        model.addAttribute("blogger",blogger);
        return "blogger";
    }

    @RequestMapping("/getList")
    public String getList(Model model){
        Blogger blogger1 = new Blogger(1L, "冯建超", "fjc");
        Blogger blogger2 = new Blogger(2L, "吕书瑶", "lsy");
        List<Blogger> list=new ArrayList<>();
        list.add(blogger1);
        list.add(blogger2);
        model.addAttribute("list",list);
        return "list";
    }
}
