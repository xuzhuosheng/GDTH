package com.example.gdtheurekacomsumerweb.controller.Ywgl;

import com.example.gdtheurekacomsumerweb.entity.Rjywgl;
import com.example.gdtheurekacomsumerweb.entity.User;
import com.example.gdtheurekacomsumerweb.service.RjywglService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RjywglController {

    private ModelAndView view;

    @Autowired
    private RjywglService rjywglService;

    private Map<String, String> resultMap;

    @RequestMapping ("toRjywglIndex")
    public ModelAndView toRjywglIndex(ModelMap map) {
        view = new ModelAndView();

        try {
            List<Rjywgl> dataList = new ArrayList<>();
            dataList = rjywglService.getData();

            if (dataList.size() > 0) {
                if ("error".equals(dataList.get(0).getBz())) {
                    map.put("msg", "程序无法调度服务，请联系管理员！");
                } else if ("wrong".equals(dataList.get(0).getBz())) {
                    map.put("msg", "数据库连接错误，请联系管理员！");
                } else {
                    map.put("dataList", dataList);
                }
            } else {
                map.put("dataList", dataList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        view.setViewName("ywgl/rj/rjyw_index");


        return view;
    }

    @RequestMapping ("toRjywAdd")
    public ModelAndView toRjywAdd() {
        view = new ModelAndView();
        view.setViewName("ywgl/rj/rjyw_add");
        return view;

    }


    @RequestMapping (value = "/doSaveRjywjl", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap doSaveRjywjl(HttpServletRequest request, HttpSession session) {
        ModelMap map = new ModelMap();

        String title = request.getParameter("title");
        String type = request.getParameter("type");
        String content = request.getParameter("content");
        String scripttxt = request.getParameter("scripttxt");
        String bz = request.getParameter("bz");
        User user = (User) session.getAttribute("user");
        String creator = user.getAccount();

        try {
            resultMap = new HashMap<>();
            resultMap = rjywglService.saveRjywjl(title, type, content, scripttxt, bz, creator);

            if ("error".equals(resultMap.get("flag"))) {
                map.put("msg", "保存失败！无法调度服务！");
            }
            if ("wrong".equals(resultMap.get("flag"))) {
                map.put("msg", "保存失败！数据库错误，请联系管理员！");
            }
            if ("success".equals(resultMap.get("flag"))) {
                map.put("msg", "保存成功！");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }

//    @RequestMapping(value = "/doSaveUser", method = RequestMethod.POST)
//    @ResponseBody
//    public ModelMap doSaveUser(HttpServletRequest request) {
//        ModelMap map = new ModelMap();
//
//        String username = request.getParameter("username");
//        String truename = request.getParameter("truename");
//        String sex = request.getParameter("sex");
//        String email = request.getParameter("email");
//        String phone = request.getParameter("phone");
//        try {
//            Map<String, String> userMap = providerXtgnService.insertUserData(username, truename, sex, email, phone);
//            if (!userMap.isEmpty()) {
//                if ("error".equals(userMap.get("flag"))) {
//                    map.put("msg", "保存失败！网络连接错误！");
//                } else {
//                    map.put("msg", "保存成功！");
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            map.put("msg", "保存失败！" + e.getMessage());
//        }
//
//        return map;
//    }
}
