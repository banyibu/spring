package com.banyibu.springboot01.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {

//    @ResponseBody
    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("msg", "hello!");
        return "/moban/index.html";
    }
}
