package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Car;
import com.atguigu.boot.bean.Person;
import com.atguigu.boot.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@ResponseBody
@Controller
@Slf4j
public class HellorController {

    @Autowired
    Car car;

    @Autowired
    Person person;


    @RequestMapping(value = "/hello" ,method = RequestMethod.POST)
    public String handle01(@RequestParam("name") String name,@RequestBody List<Map> user) {
        log.info("请求进来了...."+user.get(0).get("name"));
        return "Hello,SpringBoot2! 桂志超"+name;
    }


    @RequestMapping(value = "/hello2",produces = "application/json; charset=utf-8")
    public Car handle02() {
        return car;
    }

    @RequestMapping(value = "/person")
    public String handle03() {
        return person.toString();
    }
}
