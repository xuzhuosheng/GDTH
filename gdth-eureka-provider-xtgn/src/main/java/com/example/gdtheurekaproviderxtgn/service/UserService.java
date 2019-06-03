package com.example.gdtheurekaproviderxtgn.service;

import com.example.gdtheurekaproviderxtgn.entity.User;

import java.util.List;

public interface UserService {
    User getUserData(String username, String password);

    List<Object> getAllUser();
}
