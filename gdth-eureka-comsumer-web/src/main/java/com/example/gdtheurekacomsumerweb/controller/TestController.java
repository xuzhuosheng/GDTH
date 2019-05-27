package com.example.gdtheurekacomsumerweb.controller;


import com.example.gdtheurekacomsumerweb.service.TestService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {


    @Autowired
    TestService testService;



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
}
