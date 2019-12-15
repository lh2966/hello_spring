package com.lhh.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class hello_World {
    @GetMapping("/")
    public String hello(){
        return "index";
    }
}
