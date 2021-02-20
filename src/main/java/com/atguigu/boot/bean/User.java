package com.atguigu.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class User {
    private String name;
    private String age;
    private Pet pet;

    public User(String name,String age){
        this.name = name;
        this.age = age;
    }
}
