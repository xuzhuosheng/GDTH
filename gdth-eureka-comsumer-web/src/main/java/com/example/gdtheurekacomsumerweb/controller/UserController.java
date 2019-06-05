package com.example.gdtheurekacomsumerweb.controller;


import com.example.gdtheurekacomsumerweb.entity.User;
import com.example.gdtheurekacomsumerweb.service.ProviderXtgnService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {


    @Autowired
    ProviderXtgnService providerXtgnService;

    ModelAndView view;

    @RequestMapping("/toUserIndex")
    public ModelAndView toUserIndex(ModelMap map) {
        try {
            List<User> dataList = providerXtgnService.getAllUser();

            if (dataList.size() > 0) {
                if ("error".equals(dataList.get(0).getAccount())) {
                    map.put("msg", "网络错误！请联系管理员！");
                } else {
                    map.put("dataList", dataList);
                }
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


    @RequestMapping(value = "/doSaveUser", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap doSaveUser(HttpServletRequest request) {
        ModelMap map = new ModelMap();

        String username = request.getParameter("username");
        String truename = request.getParameter("truename");
        String sex = request.getParameter("sex");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        System.out.println(truename);
        map.put("msg", "保存成功！");
        return map;
    }


    @RequestMapping("/toUserText")
    public ModelAndView toUserText() {
        view = new ModelAndView();
        System.out.println("toUserText");
        view.setViewName("user/userText");
        return view;
    }

}
