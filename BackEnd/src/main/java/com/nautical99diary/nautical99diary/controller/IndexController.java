package com.nautical99diary.nautical99diary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/loginForm")
    public String getLoginForm(){
        return "loginForm";
    }
}
