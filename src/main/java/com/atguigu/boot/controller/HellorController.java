package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Car;
import com.atguigu.boot.bean.Person;
import com.atguigu.boot.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@ResponseBody
//@Controller
@RestController
@Slf4j
public class HellorController {

    @Autowired
    Car car;

    @Autowired
    Person person1;
//    @Autowired
//    Person person;

    @Autowired
    User user01;


    @RequestMapping(value = "/hello" ,method = RequestMethod.POST)
    public String handle01(@RequestParam("name") String name,@RequestBody User user) {
        log.info("请求进来了...."+user.toString());
        return "Hello,SpringBoot2! 桂志超"+name+user01.toString();
    }


    @RequestMapping(value = "/hello2",produces = "application/json; charset=utf-8")
    public Car handle02() {
        return car;
    }

    @RequestMapping(value = "/person")
    public String handle03() {
        return person1.toString();
    }


    //    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @GetMapping("/user")
    public String getUser(){
        return "GET-张三";
    }

//    @RequestMapping(value = "/user",method = RequestMethod.POST)
    @PostMapping("/user")
    public String saveUser(){
        return "POST-张三";
    }


//    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    @PutMapping("/user")
    public String putUser(){
        return "PUT-张三";
    }

//    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    @DeleteMapping("/user")
    public String deleteUser(){
        return "DELETE-张三";
    }
}
