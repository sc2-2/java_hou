package com.sckj.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private final static Logger logger= LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/log")
    public String testLog(){
        logger.debug("======测试日志的Debug级别打印====");
        logger.info("======测试日志info级别打印=====");
        logger.error("=====测试日志error级别打印====");
        logger.warn("======测试日志warn级别打印=====");
        //打印输出日志
        String str1="blog.hzh.com";
        String str2="blog.csdn.net/hezhenhong_34";
        logger.info("何镇宏的个人博客{}:何镇宏的CSDN博客:{}",str1,str2);
        return "success";
    }
}
