package com.example.gdtheurekaproviderxtgn.controller;


import com.example.gdtheurekaproviderxtgn.entity.User;
import com.example.gdtheurekaproviderxtgn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class GdthEurekaComsumerWebController {

    @Autowired
    UserService userService;

    @Value("${init.password}")
    private String initPassword;

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

    @RequestMapping("/getAllUser")
    public List<User> getAllUser() {
        List<User> dataList = new ArrayList<>();
        try {
            dataList = userService.getAllUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataList;

    }

    @RequestMapping("/insertUserData")
    public Map<String, String> insertUserData(String username, String truename, String sex, String email, String phone) {
        Map<String, String> userMap = new HashMap<>();
        try {
            userService.insertUserData(username, initPassword, truename, sex, email, phone);
            userMap.put("flag", "success");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userMap;
    }
}
