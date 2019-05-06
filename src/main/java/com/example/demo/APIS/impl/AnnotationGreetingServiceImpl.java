package com.example.demo.APIS.impl;

import com.example.demo.APIS.APIS.GreetingService;
import com.example.demo.APIS.AnnotationConstants;
import org.apache.dubbo.config.annotation.Service;


@Service(version = AnnotationConstants.VERSION)
public class AnnotationGreetingServiceImpl implements GreetingService {

    @Override
    public String greeting(String name) {
        System.out.println("provider received invoke of Greeting: " + name);
        sleepWhile();
        return "Annotation, fine " + name;
    }

    public String replyGreeting(String name) {
        System.out.println("provider received invoke of replyGreeting: " + name);
        sleepWhile();
        return "Annotation, fine " + name;
    }

    private void sleepWhile() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
