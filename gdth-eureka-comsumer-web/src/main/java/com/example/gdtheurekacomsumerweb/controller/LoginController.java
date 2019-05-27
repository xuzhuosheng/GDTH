package com.example.gdtheurekacomsumerweb.controller;


import com.example.gdtheurekacomsumerweb.entity.User;
import com.example.gdtheurekacomsumerweb.service.ProviderUtilService;
import com.example.gdtheurekacomsumerweb.service.ProviderXtgnService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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


    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public ModelMap doLogin(@RequestBody Map<String, Object> paramMap) {
//        接收json格式数据
        ModelMap modelMap = new ModelMap();
        String username = paramMap.get("username").toString();
        String password = paramMap.get("password").toString();
        return modelMap;
    }


    /**
     * 登录方法
     *
     * @param request
     * @param map
     * @return
     */
    @RequestMapping(value = "/doLogin2", method = RequestMethod.POST)
    public ModelAndView doLogin2(HttpServletRequest request, ModelMap map) {
//        接收参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            view = new ModelAndView();
            //feign访问微服务
            Map<String, Object> dMap = providerXtgnService.getUserData(username, password);
            if (!dMap.isEmpty()) {
                view.setViewName("login");
                String flag = dMap.get("flag").toString();
//                熔断器
//                如果是由于网络或者其他原因导致熔断，程序会跳到ProviderXtgnServiceImpl，执行熔断器的方法，再返回信息
                if ("hystrixError".equals(flag)) {
                    map.put("msg", dMap.get("errorMsg").toString());
                }
                if ("success".equals(flag)) {
                    //将Object对象转成User
                    JSONObject userJson = JSONObject.fromObject(dMap.get("user"));
                    User user = (User) JSONObject.toBean(userJson, User.class);
                    if (user == null) {
                        map.put("msg", "登录失败，请检查用户名和密码是否匹配！");
                    } else {
                        view.setViewName("index");
                        map.put("username", user.getAccount());
                        System.out.println("username:" + user.getTruename());
                    }

                }
                if ("error".equals(flag)) {
                    view.setViewName("login");
                    map.put("msg", "登录失败，请联系管理员！" + dMap.get("errorMsg").toString());
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }


    @RequestMapping("/toWelcome")
    public ModelAndView toWelcome(HttpServletResponse response) {
        List<String> title = new ArrayList<>();
        title.add("姓名");
        title.add("性别");
        title.add("年龄");
        List<String> data1 = new ArrayList<>();
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

        providerUtilService.exportExcel(title, data, response);
        view = new ModelAndView();
        view.setViewName("welcome");
        return view;
    }


}
