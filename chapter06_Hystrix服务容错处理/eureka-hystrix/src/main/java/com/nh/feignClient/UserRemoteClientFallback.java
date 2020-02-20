package com.nh.feignClient;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class UserRemoteClientFallback implements FallbackFactory<UserRemotClient> {
    @Override
    public UserRemotClient create(final Throwable cause) {
        System.out.println("UserRemoteClient回退:"+cause);
        return new UserRemotClient() {
            @Override
            public String hello() {
                return"失败";
            }
        };
    }

}
