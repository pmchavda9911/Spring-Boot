package com.example.controller;


import com.example.springboot.StudentRepo.StudentRepo;
import com.example.springboot.test.Employee.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Scanner;


@RestController

@PropertySources({
        @PropertySource("classpath:/example.properties"),
        @PropertySource("classpath:/another.properties")
})
@RequestMapping("/Student")
public class NewController {
    Logger logger = LoggerFactory.getLogger(NewController.class);

    @Value("${MyName}")
    String MyName;
    @Value("${City}")
    String City;

    @RequestMapping
    public String home() {
//        logger.error("This is an error");
//        logger.warn("This is a warning");
//        logger.info("This is an info");       //logging
        return "Hi " + MyName + " from " + City + " This is New Controller Method ";
    }

    @RequestMapping("/error")
    public String error(){
        return "The page you are looking for is not available";
    }

    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("message","Hello World");
        return "helloworld";
    }

    @RequestMapping("/add")
    String addStudent(){
        return "home.jsp";
    }
//    @RequestMapping("/specificUrl")
//    public String specificUrl(){
//        return "This is test for specific url filter";
//    }

}

