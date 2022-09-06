package com.amazon.guice;

public class GuiceServiceImpl implements GuiceService {

    @Override
    public String sayHello() {
        return "Hello from Guice & Java Spark";
    }

}
