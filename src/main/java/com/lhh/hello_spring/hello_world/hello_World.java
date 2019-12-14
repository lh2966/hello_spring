package com.lhh.hello_spring.hello_world;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sun.misc.Contended;

@Controller
public class hello_World {
    @GetMapping("/hello")
    public String hello(@RequestParam(name= "name")String name, Model model){
        model.addAttribute("name",name);
        return "hello";
    }
}
