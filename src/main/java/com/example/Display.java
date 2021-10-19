package com.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan(basePackages = {"com.example"})
//  @Component
public class Display {

    public String dname;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public void access(){
        System.out.println("Display visible");
    }
}
