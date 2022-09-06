package com.amazon.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringController {

    private final SpringService springService;

    @Autowired
    public SpringController(SpringService springService) {
        this.springService = springService;
    }

    @GetMapping("/")
    public ResponseEntity<String> sayHello() {
        String hello = this.springService.sayHello();
        return ResponseEntity.ok(hello);
    }

}
