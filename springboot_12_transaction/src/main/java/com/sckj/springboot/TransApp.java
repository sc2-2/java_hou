package com.sckj.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sckj.springboot.dao")
public class TransApp {

    public static void main(String[] args) {
        SpringApplication.run(TransApp.class,args);
    }
}
