package com.nh.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HlloController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/callHello")
    @HystrixCommand(fallbackMethod = "defaultCallHello")
    public String callHello(){
        String result = restTemplate.getForObject("http://localhost:8080/house/hello",String.class);
        return result;
    }
    public String defaultCallHello(){
        return "fail";
    }

}
