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
    public Map<String, Object> getUserData(String username, String password) {
        System.out.println(username + "---" + password);
        Map<String, Object> map = new HashMap<>();
        User user;
        try {
            user = userService.getUserData(username, password);
            map.put("user", user);
            map.put("flag", "success");

        } catch (Exception e) {
            e.printStackTrace();
            map.put("flag", "error");
            map.put("errorMsg", "数据库访问出错！");
        }
        return map;
    }

    @RequestMapping("getAllUser")
    public List<Object> getAllUser() {
        List<Object> dataList = new ArrayList<>();
        try {
            dataList = userService.getAllUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataList;

    }
}
