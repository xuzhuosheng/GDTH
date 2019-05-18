package com.example.gdtheurekacomsumerweb.controller;


import com.example.gdtheurekacomsumerweb.service.ProviderXtgnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {


    @Autowired
    ProviderXtgnService providerXtgnService;

    private ModelAndView view;

    @RequestMapping("/toLogin")
    public ModelAndView toLogin() {
        view = new ModelAndView();

        String message = providerXtgnService.getMessage();
        System.out.println(message);

        view.setViewName("login");
        return view;
    }


    @RequestMapping("/expExcel")
    public void expExcel() {

    }


}
