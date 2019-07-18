package com.example.gdtheurekacomsumerweb.controller.Ywgl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class YjywglController {

    private ModelAndView view;

    @RequestMapping ("/toYjywglIndex")
    public ModelAndView toYjywglIndex() {
        view = new ModelAndView();
        view.setViewName("ywgl/yj/yjyw_index");
        return view;
    }

}
