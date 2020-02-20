package com.example.demo.feignService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="eureka-client-user-service",configuration = com.example.demo.config.FeignConfiguration.class)
public interface UserRemoteClient {
    @GetMapping("/user/hello")
    String hello();
    @GetMapping("/user/hello2")
    String hello2(@RequestParam("name")String name);
}
