package com.example.gdtheurekacomsumerweb.service.impl;

import com.example.gdtheurekacomsumerweb.entity.Rjywgl;
import com.example.gdtheurekacomsumerweb.service.RjywglService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RjywglServiceImpl implements RjywglService {

    private Map<String, String> resultMap;

    private List<Rjywgl> dataList;

    @Override
    public Map<String, String> saveRjywjl(String title, String type, String content, String scripttxt, String bz,
                                          String creator) {

        resultMap = new HashMap<>();
        resultMap.put("flag", "error");

        return resultMap;
    }

    @Override
    public List<Rjywgl> getData(String searchContent, String selectType) {
        dataList = new ArrayList<>();
        Rjywgl rjywgl = new Rjywgl();
        rjywgl.setBz("error");
        dataList.add(rjywgl);
        return dataList;
    }

    @Override
    public Map<String, String> delRjywData(String ids) {
        resultMap = new HashMap<>();
        resultMap.put("flag", "error");
        return resultMap;
    }
}
