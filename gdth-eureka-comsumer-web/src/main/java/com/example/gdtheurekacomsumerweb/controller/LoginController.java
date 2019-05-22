package com.example.gdtheurekacomsumerweb.controller;


import com.example.gdtheurekacomsumerweb.entity.User;
import com.example.gdtheurekacomsumerweb.service.ProviderXtgnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class LoginController {


    @Autowired
    ProviderXtgnService providerXtgnService;

    private ModelAndView view;

    @RequestMapping("/toLogin")
    public ModelAndView toLogin() {
        view = new ModelAndView();
        view.setViewName("login");
        return view;
    }


    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public ModelMap doLogin(@RequestBody Map<String, Object> paramMap) {
//        接收json格式数据
        ModelMap modelMap = new ModelMap();
        String username = paramMap.get("username").toString();
        String password = paramMap.get("password").toString();
        return modelMap;
    }


    @RequestMapping(value = "/doLogin2", method = RequestMethod.POST)
    public ModelAndView doLogin2(HttpServletRequest request, ModelMap map) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            view = new ModelAndView();
//            User user = new User();
            User user = providerXtgnService.getUserData(username, password);
            if (user != null) {
                System.out.println(user.getAccount());
                view.setViewName("index");
                map.put("email", user.getEmail());
                map.put("truename", user.getTruename());

            } else {
                view.setViewName("login");
                map.put("msg", "登录失败，请检查用户名和密码是否正确！");
            }
        } catch (Exception e) {
            view.setViewName("error");
            map.put("errorMsg", e.getMessage());
            e.printStackTrace();
        }

        return view;
    }


}
