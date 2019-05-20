package com.example.gdtheurekaproviderdemo.dao;


import com.example.gdtheurekaproviderdemo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public interface UserDao {
    List<User> getData();
}
