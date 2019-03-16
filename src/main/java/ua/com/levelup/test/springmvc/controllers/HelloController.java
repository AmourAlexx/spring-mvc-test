package ua.com.levelup.test.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping
public class HelloController {

    @GetMapping("/hello")
    public String hello(ModelMap map){
        map.addAttribute("name","Andrei");
        return "hello";
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
