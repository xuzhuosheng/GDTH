package com.example.gdtheurekacomsumerweb.entity;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable {


    private int id;
    private String account;
    private String email;
    private String password;
    private String sex;
    private String truename;
    private String phone;
    private String zt;
    private Date createTime;
    private Date modifyTime;


    public User() {
    }


    public User(int id, String account, String email, String password, String sex, String truename, String phone, String zt, Date createTime, Date modifyTime) {
        this.id = id;
        this.account = account;
        this.email = email;
        this.password = password;
        this.sex = sex;
        this.truename = truename;
        this.phone = phone;
        this.zt = zt;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
