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

    @Autowired
    private RjywglService rjywglService;

    private ModelAndView view;

    private List<Rjywgl> dataList;
    private Map<String, String> resultMap;
    private ModelMap map;

    @RequestMapping ("toRjywglIndex")
    public ModelAndView toRjywglIndex(ModelMap map, HttpServletRequest request) {
        view = new ModelAndView();

        String searchContent = request.getParameter("searchContent");
        String selectType = request.getParameter("selectType");

        try {
            dataList = new ArrayList<>();
            dataList = rjywglService.getData(searchContent, selectType);

            if (dataList.size() > 0) {
                if ("error".equals(dataList.get(0).getBz())) {
                    map.put("msg", "程序无法调度服务，请联系管理员！");
                    view.setViewName("error");
                } else if ("wrong".equals(dataList.get(0).getBz())) {
                    map.put("msg", "数据库连接错误，请联系管理员！");
                    view.setViewName("error");
                } else {
                    map.put("dataList", dataList);
                    view.setViewName("ywgl/rj/rjyw_index");
                }
            } else {
                map.put("dataList", dataList);
                view.setViewName("ywgl/rj/rjyw_index");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }


    @RequestMapping ("toRjywglSearch")
    @ResponseBody
    public ModelMap toRjywglSearch(HttpServletRequest request) {
        ModelMap map = new ModelMap();

        String searchContent = request.getParameter("searchContent");
        String selectType = request.getParameter("selectType");

        try {
            dataList = new ArrayList<>();
            dataList = rjywglService.getData(searchContent, selectType);

            if (dataList.size() > 0) {
                if ("error".equals(dataList.get(0).getBz())) {
                    map.put("flag", "error");
                    map.put("msg", "程序无法调度服务，请联系管理员！");
                } else if ("wrong".equals(dataList.get(0).getBz())) {
                    map.put("flag", "error");
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
        return map;
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


    @RequestMapping (value = "toDelData", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap toDelData(HttpServletRequest request) {
        map = new ModelMap();
        String ids = request.getParameter("ids");
        try {
            resultMap = new HashMap<>();
            resultMap = rjywglService.delRjywData(ids);
            if("error".equals(resultMap.get("flag")))
            {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }


}
