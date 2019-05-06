package com.example.demo.APIS.APIS;

public interface HelloService {

    String sayHello(String name);

    default String sayGoodbye(String name) {
        return "Goodbye, " + name;
    }
}
