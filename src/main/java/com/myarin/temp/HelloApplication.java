package com.myarin.temp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myarin.temp.dtos.Message;


@RestController
public class HelloApplication {
    @GetMapping("/hello")
    public Message sayHello() {
        return new Message("Hello, World!");
    }
    
}
