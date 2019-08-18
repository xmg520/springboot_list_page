package com.mzx.springbootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//入口控制器
@Controller
public class MyMain {


    @GetMapping(value = {""})
    public String login(){
        return "login.html";
    }
}
