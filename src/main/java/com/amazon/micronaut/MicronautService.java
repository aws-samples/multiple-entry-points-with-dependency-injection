package com.amazon.micronaut;

import jakarta.inject.Singleton;

@Singleton
public class MicronautService {

    public String sayHello() {
        return "Hello from Micronaut";
    }

}
