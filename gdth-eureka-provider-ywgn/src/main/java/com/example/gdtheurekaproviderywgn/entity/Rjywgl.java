package com.example.gdtheurekaproviderywgn.entity;


import java.sql.Date;
import java.sql.Timestamp;

public class Rjywgl {

    private long id;
    private String type;
    private String title;
    private String content;
    private String scripttxt;
    private String creator;
    private Timestamp createtime;
    private String modify;
    private Date modifytime;
    private String bz;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getScripttxt() {
        return scripttxt;
    }

    public void setScripttxt(String scripttxt) {
        this.scripttxt = scripttxt;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    public String getModify() {
        return modify;
    }

    public void setModify(String modify) {
        this.modify = modify;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }
}
