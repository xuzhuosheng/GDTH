package com.example.gdtheurekaproviderdemo.service.impl;

import com.example.gdtheurekaproviderdemo.dao.UserDao;
import com.example.gdtheurekaproviderdemo.entity.User;
import com.example.gdtheurekaproviderdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("userService")
public class UserServiceImpl implements UserService {


    @Autowired
    UserDao userDao;

    @Override
    public List<User> getData() {
        List<User> userList = userDao.getData();
        return userList;
    }
}
