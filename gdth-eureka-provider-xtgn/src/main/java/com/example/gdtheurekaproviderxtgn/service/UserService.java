package com.example.gdtheurekaproviderxtgn.service;

import com.example.gdtheurekaproviderxtgn.entity.User;

import java.util.List;

public interface UserService {
    User getUserData(String username, String password);

    List<User> getAllUser();

    void insertUserData(String username, String initPassword, String truename, String sex, String email, String phone);
}
