package com.nh.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value="http://localhost:8080/callHello",fallbackFactory = UserRemoteClientFallback.class)
public interface UserRemotClient {
    @GetMapping("/user/hello")
    String hello();
}
