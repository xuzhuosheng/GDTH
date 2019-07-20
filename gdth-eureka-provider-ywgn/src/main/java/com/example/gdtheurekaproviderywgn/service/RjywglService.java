package com.example.gdtheurekaproviderywgn.service;

import com.example.gdtheurekaproviderywgn.entity.Rjywgl;

import java.util.List;

public interface RjywglService {
    void insertRjywjl(String title, String type, String content, String scripttxt, String bz, String creator);

    List<Rjywgl> getData(String searchContent, String selectType);
}
