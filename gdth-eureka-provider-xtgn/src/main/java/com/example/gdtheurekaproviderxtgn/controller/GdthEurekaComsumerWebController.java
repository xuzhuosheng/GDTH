package com.example.gdtheurekaproviderxtgn.controller;


import com.example.gdtheurekaproviderxtgn.entity.User;
import com.example.gdtheurekaproviderxtgn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class GdthEurekaComsumerWebController {

    @Autowired
    UserService userService;

    @RequestMapping("/getUserData")
    public User getUserData(String username, String password) {
        System.out.println(username + "---" + password);
        User user = new User();
        try {
            user = userService.getUserData(username, password);
        } catch (Exception e) {
            System.out.println("getUserData is wrong");
            e.printStackTrace();
        }
        return user;
    }

    @RequestMapping("getAllUser")
    public List<User> getAllUser() {
        List<User> dataList = new ArrayList<>();
        try {
            dataList = userService.getAllUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataList;

    }
}
