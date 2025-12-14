package com.myarin.temp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myarin.temp.dtos.Message;



@RestController
public class HelloController {
    @GetMapping("/hello")
    public Message sayHello() {
        return new Message("Hello, World!");
    }
    
    @PostMapping("/hello")
    public Message postMethodName(@RequestBody Message message) {
        return message;
    }
    
    
}
