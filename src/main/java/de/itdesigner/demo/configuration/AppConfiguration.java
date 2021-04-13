package de.itdesigner.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    
    @Bean("myname")
    public String myname() {
        return "Andreas";
    }

}
