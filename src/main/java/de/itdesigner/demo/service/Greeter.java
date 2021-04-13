package de.itdesigner.demo.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class Greeter {

    private final String name;

    public Greeter(@Qualifier("myname") String name) {
        this.name = name;
    }

    public String getGreeting() {
        return "Hello " + name + "!";
    }

}
