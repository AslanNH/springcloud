package com.nh;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class MyHystrixCommand extends HystrixCommand {
    private final String name;
    public MyHystrixCommand(String name){
        super(HystrixCommandGroupKey.Factory.asKey("MyGroup"));
        this.name = name;
    }
    @Override
    protected String run() throws Exception {
       // Thread.sleep(1000);
        System.out.println("get data");
        return this.name +":"+Thread.currentThread().getName();
    }

    @Override
    protected Object getFallback() {
        return "失败了";
    }

    @Override
    protected String getCacheKey() {
        return String.valueOf(this.name);
    }

}
