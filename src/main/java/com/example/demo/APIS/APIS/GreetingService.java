package com.example.demo.APIS.APIS;


import java.util.concurrent.CompletableFuture;

public interface GreetingService {

    String greeting(String name);

    default String replyGreeting(String name) {
        return "Fine, " + name;
    }


    //异步执行的接口函数定义
    default CompletableFuture<String> greeting(String name, byte signal) {
        return CompletableFuture.completedFuture(greeting(name));
    }

}