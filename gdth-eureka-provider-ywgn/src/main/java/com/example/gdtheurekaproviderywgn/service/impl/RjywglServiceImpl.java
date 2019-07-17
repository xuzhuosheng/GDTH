package com.example.gdtheurekaproviderywgn.service.impl;


import com.example.gdtheurekaproviderywgn.dao.RjywglDao;
import com.example.gdtheurekaproviderywgn.service.RjywglService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository ("rjywglService")
public class RjywglServiceImpl implements RjywglService {

    @Autowired
    private RjywglDao rjywglDao;

    @Override
    public void insertRjywjl(String title, String type, String content, String scripttxt, String bz, String creator) {
        rjywglDao.insertRjywjl(title, type, content, scripttxt, bz, creator);
    }
}
