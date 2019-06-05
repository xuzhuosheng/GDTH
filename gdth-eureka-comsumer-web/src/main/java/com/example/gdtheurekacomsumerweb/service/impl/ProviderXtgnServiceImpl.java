package com.example.gdtheurekacomsumerweb.service.impl;

import com.example.gdtheurekacomsumerweb.entity.User;
import com.example.gdtheurekacomsumerweb.service.ProviderXtgnService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class ProviderXtgnServiceImpl implements ProviderXtgnService {

    @RequestMapping("/toError")
    public String getMessage() {
        return "error";
    }

    @Override
    public User getUserData(String username, String password) {
        System.out.println("hystrix is working!");
        User user = new User();
        user.setAccount("error");
        return user;
    }

    @Override
    public List<User> getAllUser() {
        List<User> userList = new ArrayList<>();
        User user = new User();
        user.setAccount("error");
        userList.add(user);
        return userList;
    }

    @Override
    public Map<String, String> insertUserData(String username, String truename, String sex, String email, String phone) {
        Map<String, String> userMap = new HashMap<>();
        userMap.put("flag", "error");
        return userMap;
    }
}
