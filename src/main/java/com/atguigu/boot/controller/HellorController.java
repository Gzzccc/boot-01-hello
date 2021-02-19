package com.atguigu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Controller
public class HellorController {

    @RequestMapping("/hello")
    public String handle01() {
        return "Hello,SpringBoot2!";
    }


    @RequestMapping("/hello2")
    public String handle02() {
        return "桂志超!";
    }
}
