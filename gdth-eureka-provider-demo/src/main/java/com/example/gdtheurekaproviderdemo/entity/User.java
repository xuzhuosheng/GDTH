package com.example.gdtheurekaproviderdemo.entity;

import java.io.Serializable;

public class User implements Serializable {


    private int id;
    private String account;
    private String email;
    private String password;
    private String sex;
    private String truename;


    public User() {
    }

    public User(int id, String account, String email, String password, String sex, String truename) {
        this.id = id;
        this.account = account;
        this.email = email;
        this.password = password;
        this.sex = sex;
        this.truename = truename;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }
}
