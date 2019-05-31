package com.example.gdtheurekacomsumerweb.controller;


import com.example.gdtheurekacomsumerweb.service.ProviderUtilService;
import com.example.gdtheurekacomsumerweb.service.TestService;
import feign.Response;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {


    @Autowired
    TestService testService;


    @Autowired
    ProviderUtilService providerUtilService;


    @RequestMapping("/toTest")
    public ModelAndView toTest(ModelMap map) {
        ModelAndView view = new ModelAndView();
//         = new ModelMap();
        view.setViewName("test");
        try {
            String name = testService.getAccount();
            System.out.println("TEST:--" + name);
            map.put("name", name);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }

    @RequestMapping("/doExcel")
    public void doExcel() {
        try {
            List<String> title = new ArrayList<>();
            title.add("姓名");
            title.add("性别");
            title.add("年龄");
            java.util.List<String> data1 = new ArrayList<>();
            data1.add("吴彦祖");
            data1.add("男");
            data1.add("30");
            List<String> data2 = new ArrayList<>();
            data2.add("古天乐");
            data2.add("男");
            data2.add("31");
            List<List<String>> data = new ArrayList<>();
            data.add(data1);
            data.add(data2);

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("title", title);
            jsonObject.put("data", data);

//            testService.exportExcel(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void doExcelTest() {
        List<String> title = new ArrayList<>();
        title.add("姓名");
        title.add("性别");
        title.add("年龄");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title", title);
        testService.exportExcel(jsonObject);

    }


//    @RequestMapping("/downloadFiles")
//    public ResponseEntity<byte[]> downloadFiles() {
//
//        List<String> title = new ArrayList<>();
//        title.add("aaa");
//        title.add("bbb");
//        title.add("ccc");
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("title", title);
//
//
//        ResponseEntity<byte[]> entity = null;
//        InputStream inputStream = null;
//
//        String fileName = "test_" + System.currentTimeMillis() + ".xls";
//        try {
//
//            Response response = testService.download(jsonObject);
//            Response.Body body = response.body();
//            inputStream = body.asInputStream();
//            byte[] b = new byte[inputStream.available()];
//            inputStream.read(b);
//            HttpHeaders headers = new HttpHeaders();
//            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName);
//            headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
//
//            entity = new ResponseEntity<byte[]>(b, headers, HttpStatus.OK);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (inputStream != null) {
//                try {
//                    inputStream.close();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return entity;
//
//    }
}
