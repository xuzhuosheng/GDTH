package com.example.gdtheurekacomsumerweb.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    ModelAndView view;

    @RequestMapping(value = "/toUserIndex")
    public ModelAndView toUserIndex() {
        view = new ModelAndView();
        System.out.println("this is toUserIndex method");
        view.setViewName("xt/userIndex");
        return view;
    }


}
