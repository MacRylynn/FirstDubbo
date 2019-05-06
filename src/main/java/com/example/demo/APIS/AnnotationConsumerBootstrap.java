package com.example.demo.APIS;

import com.example.demo.APIS.action.AnnotationAction;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;



public class AnnotationConsumerBootstrap {

    public static void main(String[] args) {
        System.out.println("now start...");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();
        final AnnotationAction annotationAction = (AnnotationAction) context.getBean("annotationAction");

        System.out.println("hello :" + annotationAction.doSayHello("world"));
        System.out.println("goodbye :" + annotationAction.doSayGoodbye("world"));
        long org = System.currentTimeMillis();
        System.out.println("greeting :" + annotationAction.doGreeting("world"));
        long now = System.currentTimeMillis();
        System.out.println(now-org);
        System.out.println("reply :" + annotationAction.replyGreeting("world"));
    }


    @Configuration
    @EnableDubbo(scanBasePackages = "com.example.demo.APIS.action")
    @PropertySource("classpath:/dubbo-consumer.properties")
    @ComponentScan(value = {"com.example.demo.APIS.action"})
    static public class ConsumerConfiguration {

    }

}
