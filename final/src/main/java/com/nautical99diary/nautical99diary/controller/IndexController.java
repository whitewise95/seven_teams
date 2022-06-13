package com.nautical99diary.nautical99diary.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @GetMapping({"", "/"})
    public String getHome(){
        return "index";
    }

    @GetMapping("/user/login")
    public String getLoginForm(){
        return "loginForm";
    }
}
