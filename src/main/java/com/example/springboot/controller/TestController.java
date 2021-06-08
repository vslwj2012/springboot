package com.example.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {

    @Value("${spring.datasource.url}")
    private String url;

    @GetMapping(
            value = "test",
            produces = { "application/json;charset=UTF-8" }
    )
    public String test(String message){
        System.out.println(message);
        return message;
    }

    @RequestMapping(value = "errorTest")
    public void errorTest(){
        throw new RuntimeException("运行时异常");
    }

    @ExceptionHandler
    public String doError(Exception e){
        log.info(e.getMessage());
        return e.getMessage();
    }
}
