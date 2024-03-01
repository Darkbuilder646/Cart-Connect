package com.example.jspapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWordController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "welcome";
    }
}
