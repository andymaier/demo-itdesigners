package de.itdesigner.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.itdesigner.demo.service.Greeter;

@RestController
@RequestMapping("hello")
public class HelloWorldController {
    
    @Autowired
    Greeter greeter;

    @GetMapping
    public String hello() {
        return greeter.getGreeting();
    }

}
