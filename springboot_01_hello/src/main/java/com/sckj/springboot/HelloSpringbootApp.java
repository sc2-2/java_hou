package com.sckj.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1.导入依赖包
 * 2.建立Controller控制器
 * 3.启动类
 */
@SpringBootApplication//自动配置(springmvc),扫描加了@SpringBootApplication
public class HelloSpringbootApp {
    /**
     * 一：传统的开发方式：
     * 1。启动外部的tomcat
     * 2。根据web.xml的配置信息，初始化一个Spring的容器(applicationContext.xml)
     * 3。做一些常规配置后，还要扫描一些bean(dao,service,controller)
     */
    public static void main(String[] args) {
        /**
         *
         * 二：Springboot的启动方式
         * 1.启动一个内置的tomcat
         * 2。初始化一个Spring容器
         * 3。自动配置(springmvc),扫描加了@SpringBootApplication
         * 类的当前包及其子子孙孙里面所有spring注解(@Repository @service @controller)
         */
        SpringApplication.run(HelloSpringbootApp.class,args);
    }
}
