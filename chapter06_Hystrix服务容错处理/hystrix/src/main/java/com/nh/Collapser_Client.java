package com.nh;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Collapser_Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        Future<String>f1 = new MyHystrixCollapser("aslan").queue();
        Future<String>f2 = new MyHystrixCollapser("aslanA").queue();
        System.out.println(f1.get()+"="+f2.get());
        context.shutdown();


    }
}
