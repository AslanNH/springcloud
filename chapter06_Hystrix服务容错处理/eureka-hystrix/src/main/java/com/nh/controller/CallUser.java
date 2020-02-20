package com.nh.controller;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.nh.feignClient.UserRemotClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CallUser {
    @Autowired
    private UserRemotClient userRemotClient;

    @GetMapping("/user/hello")
    public String callHello(){

        return userRemotClient.hello();
    }

}
