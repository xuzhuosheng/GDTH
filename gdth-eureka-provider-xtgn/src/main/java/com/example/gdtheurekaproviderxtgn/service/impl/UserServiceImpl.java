package com.example.gdtheurekaproviderxtgn.service.impl;

import com.example.gdtheurekaproviderxtgn.dao.UserDao;
import com.example.gdtheurekaproviderxtgn.entity.User;
import com.example.gdtheurekaproviderxtgn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User getUserData(String username, String password) {
        User user = userDao.getUserData(username, password);
        return user;
    }
}