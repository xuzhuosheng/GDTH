package com.example.gdtheurekacomsumerweb.service.impl;

import com.example.gdtheurekacomsumerweb.service.ProviderXtgnService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;


@Component
public class ProviderXtgnServiceImpl implements ProviderXtgnService {

    @RequestMapping("/toError")
    public String getMessage() {
        return "error";
    }

    @Override
    public Map<String, Object> getUserData(String username, String password) {
        System.out.println("hystrix is working!");
        Map<String, Object> map = new HashMap<>();
        map.put("flag", "hystrixError");
        map.put("errorMsg", "微服务调度错误，请联系管理员！");
        return map;
    }
}
