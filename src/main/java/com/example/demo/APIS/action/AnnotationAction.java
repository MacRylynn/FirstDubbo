package com.example.demo.APIS.action;

import com.example.demo.APIS.APIS.GreetingService;
import com.example.demo.APIS.APIS.HelloService;
import com.example.demo.APIS.AnnotationConstants;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Reference;


import org.springframework.stereotype.Component;

@Component("annotationAction")
public class AnnotationAction {
    //version用来控制版本
    @Reference(interfaceClass = HelloService.class, version = AnnotationConstants.VERSION)
    private HelloService helloService;

    @Reference(interfaceClass = GreetingService.class, version = AnnotationConstants.VERSION, methods = {@Method(name = "greeting", timeout = 250, retries = 1)})
    private GreetingService greetingService;

    public String doSayHello(String name) {
        try {
            return helloService.sayHello(name);
        } catch (Exception e) {
            e.printStackTrace();
            return "Throw Exception";
        }
    }

    public String doSayGoodbye(String name) {
        try {
            return helloService.sayGoodbye(name);
        } catch (Exception e) {
            e.printStackTrace();
            return "Throw Exception";
        }

    }

    public String doGreeting(String name) {
        try {
            return greetingService.greeting(name);
        } catch (Exception e) {
            e.printStackTrace();
            return "Throw Exception";
        }

    }

    public String replyGreeting(String name) {
        try {
            return greetingService.replyGreeting(name);
        } catch (Exception e) {
            e.printStackTrace();
            return "Throw Exception";
        }
    }
}