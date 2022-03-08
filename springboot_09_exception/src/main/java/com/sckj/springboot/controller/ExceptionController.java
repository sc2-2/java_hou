package com.sckj.springboot.controller;

import com.sckj.springboot.entity.JsonResult;
import com.sckj.springboot.exception.BusinessErrorException;
import com.sckj.springboot.exception.BusinessMsgEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exception")
public class ExceptionController {

    private static final Logger logger =
            LoggerFactory.getLogger(ExceptionController.class);

    @PostMapping("/test")
    public JsonResult test(@RequestParam("name")String name,@RequestParam("pass")String pass){
        logger.info("name:{}",name);
        logger.info("pass:{}",pass);
        return new JsonResult();
    }

    @GetMapping("/null/point/exception")
    public JsonResult testNullPointException() {
        String str = null;
        str.length();
        return new JsonResult();
    }


    @GetMapping("/business")
    public JsonResult testException(){
        try {
            int i=1/0;
        }catch (Exception exception){
            throw new BusinessErrorException(BusinessMsgEnum.UNEXPECTED_EXCEPTION);
        }
        return new JsonResult();
    }



}
