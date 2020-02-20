package com.nh;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

import java.util.concurrent.Future;

public class Command_Client {
    public static void main(String[] args) throws Exception{
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        //1.同步调用
        String result = (String) new MyHystrixCommand("aslan").execute();
        System.out.println(result);

        //2.异步调用,会在future.get()的时候阻塞
        Future<String> future = new MyHystrixCommand("aslan").queue();
        System.out.println(future.get());
        context.shutdown();
    }
}
