package com.example.gdtheurekaproviderywgn.service.impl;


import com.example.gdtheurekaproviderywgn.dao.RjywglDao;
import com.example.gdtheurekaproviderywgn.entity.Rjywgl;
import com.example.gdtheurekaproviderywgn.service.RjywglService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository ("rjywglService")
public class RjywglServiceImpl implements RjywglService {

    @Autowired
    private RjywglDao rjywglDao;

    private List<Rjywgl> dataList;

    @Override
    public void insertRjywjl(String title, String type, String content, String scripttxt, String bz, String creator) {
        rjywglDao.insertRjywjl(title, type, content, scripttxt, bz, creator);
    }

    @Override
    public List<Rjywgl> getData() {
        dataList = new ArrayList<>();
        dataList = rjywglDao.getData();
        return dataList;
    }
}
