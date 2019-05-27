package com.example.gdtheurekaproviderutil.entity;


import java.io.Serializable;

public class WxUser implements Serializable {

    private String openid;
    private String name;
    private String userid;
    private String mobile;

    public WxUser(String openid, String name, String userid, String mobile) {
        this.openid = openid;
        this.name = name;
        this.userid = userid;
        this.mobile = mobile;
    }

    public WxUser() {
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
