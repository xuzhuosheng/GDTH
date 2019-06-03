package com.example.gdtheurekacomsumerweb.controller;


import com.example.gdtheurekacomsumerweb.entity.User;
import com.example.gdtheurekacomsumerweb.service.ProviderXtgnService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {


    @Autowired
    ProviderXtgnService providerXtgnService;

    ModelAndView view;

    @RequestMapping("/toUserIndex")
    public ModelAndView toUserIndex(ModelMap map) {
        try {
            List<Object> dataList = providerXtgnService.getAllUser();

            if (dataList.size() > 0) {

                JSONObject userJson;
                User user;
                for (int i = 0, size = dataList.size(); i < size; i++) {
                    userJson = JSONObject.fromObject(dataList.get(i));
                    user = (User) JSONObject.toBean(userJson, User.class);
                    System.out.println(user.getAccount());
                    System.out.println(user.getTruename());
                }
                map.put("dataList", dataList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        view = new ModelAndView();
        view.setViewName("user/userIndex");
        return view;
    }


    @RequestMapping("/toUserAdd")
    public ModelAndView toUserAdd() {
        view = new ModelAndView();
        view.setViewName("user/userAdd");
        return view;
    }

    @RequestMapping("/toUserText")
    public ModelAndView toUserText() {
        view = new ModelAndView();
        System.out.println("toUserText");
        view.setViewName("user/userText");
        return view;
    }

}
