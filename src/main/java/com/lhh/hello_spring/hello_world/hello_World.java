package com.lhh.hello_spring.hello_world;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class hello_World {
    @GetMapping("/")
    public String hello(){
        return "indnx";
    }
}
