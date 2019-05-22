package com.example.gdtheurekaproviderxtgn.controller;


import com.example.gdtheurekaproviderxtgn.entity.User;
import com.example.gdtheurekaproviderxtgn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GdthEurekaComsumerWebController {

    @Autowired
    UserService userService;

    @RequestMapping("/getUserData")
    public User getUserData(String username, String password) throws Exception {
        System.out.println(username + "---" + password);
        User user = new User();
        try {
            user = userService.getUserData(username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }


}
