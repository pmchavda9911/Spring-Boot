package com.example.springboot;

import com.example.Display;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean
    public Laptop1 getLaptopBean(){
        return new Laptop1();
    }

    @Bean
    public Display getDisplayBean(){
        return new Display();
    }

}
