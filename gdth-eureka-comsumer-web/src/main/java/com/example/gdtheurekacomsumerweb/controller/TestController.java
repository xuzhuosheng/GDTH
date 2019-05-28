package com.example.gdtheurekacomsumerweb.controller;


import com.example.gdtheurekacomsumerweb.service.ProviderUtilService;
import com.example.gdtheurekacomsumerweb.service.TestService;
import com.netflix.discovery.converters.Auto;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
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
    public void doExcel(HttpServletResponse response) {
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

//            Map<String,List<List<String>>> listMap=new HashMap<>();
//
//            listMap.put("title",title);
//            listMap.put("data",data);


            providerUtilService.exportExcel(title, data, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("/toOneParam")
    public void toOneParam() {
        providerUtilService.toOneParam("wuyanzu");
    }


    @RequestMapping("/toTwoParam")
    public void toTwoParam() {
        providerUtilService.toTwoParam("wuyanzu", 30);
    }

    @RequestMapping("/toList")
    public void toList() {

        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("title",list);
        providerUtilService.toList(jsonObject);
    }
}
