package com.example.gdtheurekacomsumerweb.controller;


import com.example.gdtheurekacomsumerweb.entity.User;
import com.example.gdtheurekacomsumerweb.service.ProviderUtilService;
import com.example.gdtheurekacomsumerweb.service.ProviderXtgnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {


    @Autowired
    ProviderXtgnService providerXtgnService;


    @Autowired
    ProviderUtilService providerUtilService;

    private ModelAndView view;

    /**
     * 登录页面请求方法
     *
     * @return
     */
    @RequestMapping("/toLogin")
    public ModelAndView toLogin() {
        view = new ModelAndView();
        view.setViewName("login");
        return view;
    }


    /**
     * 登录方法
     *
     * @param request
     * @param map
     * @return
     */
    @RequestMapping(value = "/doLogin2", method = RequestMethod.POST)
    public ModelAndView doLogin2(HttpServletRequest request, ModelMap map, HttpSession session) {
//        接收参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            view = new ModelAndView();

            User user = providerXtgnService.getUserData(username, password);
            if (user == null) {
                map.put("msg", "登录失败，请检查用户名和密码是否匹配！");
                view.setViewName("login");
            } else if ("error".equals(user.getAccount())) {
                map.put("msg", "网络错误，请联系管理员！");
                view.setViewName("login");
            } else {
                view.setViewName("index");
                map.put("user", user);
                session.setAttribute("user", user);
                System.out.println("username:" + user.getTruename());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }


    @RequestMapping("/toWelcome")
    public ModelAndView toWelcome(HttpServletResponse response) {

        view = new ModelAndView();
        view.setViewName("welcome");
        return view;
    }


}
