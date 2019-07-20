package com.example.gdtheurekaproviderywgn.controller;


import com.example.gdtheurekaproviderywgn.entity.Rjywgl;
import com.example.gdtheurekaproviderywgn.service.RjywglService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RjwglController {

    private Map<String, String> resultMap;

    private List<Rjywgl> dataList;

    @Autowired
    private RjywglService rjywglService;


    @RequestMapping ("getData")
    public List<Rjywgl> getData(String searchContent, String selectType) {

        try {
            dataList = new ArrayList<>();

            dataList = rjywglService.getData(searchContent, selectType);

        } catch (Exception e) {
            e.printStackTrace();
            Rjywgl rjywgl = new Rjywgl();
            rjywgl.setBz("wrong");
            dataList.add(rjywgl);
        }
        return dataList;
    }


    @RequestMapping ("saveRjywjl")
    public Map<String, String> saveRjywjl(String title, String type, String content, String scripttxt, String bz,
                                          String creator) {
        System.out.println("ywgn");
        resultMap = new HashMap<>();
        try {
            rjywglService.insertRjywjl(title, type, content, scripttxt, bz, creator);
            resultMap.put("flag", "success");
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("flag", "wrong");
        }

        return resultMap;
    }

}
