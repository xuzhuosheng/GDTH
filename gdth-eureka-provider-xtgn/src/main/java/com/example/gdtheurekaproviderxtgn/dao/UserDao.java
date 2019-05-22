package com.example.gdtheurekaproviderxtgn.dao;


import com.example.gdtheurekaproviderxtgn.entity.User;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public interface UserDao {
    User getUserData(@Param("username") String username, @Param("password") String password);
}
