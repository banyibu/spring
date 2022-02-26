package com.banyibu.springboot01.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping("")
    public String toLoginPage(){
        return "login/extra-login";
    }

    @PostMapping("/submit")
    @ResponseBody
    public String loginSubmit(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password, HttpSession session) throws JsonProcessingException {
        Map<String, Object> result = new HashMap<>();
        result.put("login_status", "success");
        result.put("username", username);
        session.setAttribute("username", username);
        session.setAttribute("password",password);
        JsonMapper jsonMapper = new JsonMapper();
        return jsonMapper.writeValueAsString(result);
    }
}
