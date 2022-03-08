package com.sckj.springboot.controller;

import com.sckj.springboot.config.MicroServiceUrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestController {

    private static final Logger LOGGER= LoggerFactory.getLogger(ConfigController.class);

    @Resource
    private MicroServiceUrl microServiceUrl;

    @RequestMapping("/config")
    public String  testConfig(){
        LOGGER.info("获取订单的微服务地址为{}",microServiceUrl.getOrderUrl());
        LOGGER.info("=====获取的用户服务地址为：{}", microServiceUrl.getUserUrl());
        LOGGER.info("=====获取的购物车服务地址为：{}",microServiceUrl.getShoppingUrl());
        return "success";
    }

}
