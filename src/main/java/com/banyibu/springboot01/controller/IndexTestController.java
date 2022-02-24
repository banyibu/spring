package com.banyibu.springboot01.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
//@RestController 1. 该类下所有请求都不进行视图解析，直接返回字符串；
public class IndexTestController {

//    @ResponseBody 2. 返回字符串不进行视图解析，直接返回字符串和@Controller配合实用
    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("msg", "hello!");
        model.addAttribute("list", Arrays.asList("111","222","333"));
        return "index-study";
    }

    @GetMapping("/pjindex")
    public String index(Model model){
        model.addAttribute("","");
        return "moban/index";
    }
}
