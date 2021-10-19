package com.example.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/errorController")
public class MyErrorController implements ErrorController {

    private static final String PATH = "/errorPage";
    @RequestMapping(value = PATH)
    String errorPage() {
        return "This is an error page!!!";
    }

    @RequestMapping("home")
    String homePage(){
        return "home.jsp";
    }
}