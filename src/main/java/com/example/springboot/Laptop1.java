package com.example.springboot;

import com.example.Display;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@ComponentScan(basePackages = {"com.example"})
//@Component
//@Scope(value="prototype")
@PropertySource("example.properties")
public class Laptop1{

    @Autowired
    Display display1;

    Laptop1(){};

    //  @JsonCreator

    public void setDisplay1(String str) {
        display1.setDname(str);
    }

    public void Test(){
        System.out.println("Laptop Turned On");
        display1.access();
    }
}