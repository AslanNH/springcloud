package com.nh.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * java -jar **.jar --server.port**
 */
@RestController
public class UserController {
    @GetMapping("/user/hello")
    public String hello(){
        return "hello";
    }
    @GetMapping("/user/hello2")
    public String hello2(@RequestParam("name")String name){
        return name;
    }
}

