package com.lhh.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class hello_World {
    @GetMapping("/")
    public String hello(){
        return "index";
    }
}
