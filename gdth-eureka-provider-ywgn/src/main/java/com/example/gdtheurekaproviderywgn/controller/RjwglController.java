package com.example.gdtheurekaproviderywgn.controller;


import com.example.gdtheurekaproviderywgn.service.RjywglService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RjwglController {

    private Map<String, String> resultMap;

    @Autowired
    private RjywglService rjywglService;

    @RequestMapping ("saveRjywjl")
    public Map<String, String> saveRjywjl(String title, String type, String content, String scripttxt, String bz,
                                          String creator) {


        resultMap = new HashMap<>();


        try {

            rjywglService.insertRjywjl(title, type, content, scripttxt, bz, creator);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultMap;
    }

}
