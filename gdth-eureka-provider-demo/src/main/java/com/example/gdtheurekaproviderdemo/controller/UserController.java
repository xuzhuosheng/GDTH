package com.example.gdtheurekaproviderdemo.controller;


import com.example.gdtheurekaproviderdemo.entity.User;
import com.example.gdtheurekaproviderdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/toTest")
    public String toTest() {
        List<User> userList = new ArrayList<>();
        try {
            userList = userService.getData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList.get(0).getAccount();
    }


    @RequestMapping("/getAccount")
    public String getAccount() {
        List<User> userList = new ArrayList<>();
        System.out.println("this is demo ");
        String name = "";

        try {
            userList = userService.getData();
            name = userList.get(0).getAccount();
            System.out.println(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return name;
    }
}
