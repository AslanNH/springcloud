package com.example.demo;

import com.example.demo.feignService.UserRemoteClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignUserController {
    @Autowired
    private UserRemoteClient userRemoteClient;

    @GetMapping("/callHello")
    public String callHello(){
        String result = userRemoteClient.hello();
        System.out.println("调用结果:"+result);
        return result;
    }
    @GetMapping("/callHello2")
    public String callHello2(){
        String result = userRemoteClient.hello2("张三");
        System.out.println("调用结果:"+result);
        return result;
    }
}
