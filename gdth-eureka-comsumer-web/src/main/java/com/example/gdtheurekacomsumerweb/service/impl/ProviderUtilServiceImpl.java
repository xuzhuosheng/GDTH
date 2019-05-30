package com.example.gdtheurekacomsumerweb.service.impl;


import com.example.gdtheurekacomsumerweb.service.ProviderUtilService;
import feign.Response;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Component
public class ProviderUtilServiceImpl implements ProviderUtilService {
//    @Override
//    public void exportExcel(List<String> titleList, List<List<String>> dataList, HttpServletResponse response) {
//        System.out.println("exportExcel is abort");
//    }
//
//    @Override
//    public void toOneParam(String name) {
//
//    }
//
//    @Override
//    public void toTwoParam(String name, int age) {
//
//    }
//
//    @Override
//    public void toList(JSONObject jsonObject, List<String> list) {
//
//    }


    @Override
    public Response downLoadExcel() {
        return null;
    }
}
