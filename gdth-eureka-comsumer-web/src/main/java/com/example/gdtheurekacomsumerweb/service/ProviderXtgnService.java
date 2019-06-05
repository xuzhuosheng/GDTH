package com.example.gdtheurekacomsumerweb.service;


import com.example.gdtheurekacomsumerweb.entity.User;
import com.example.gdtheurekacomsumerweb.service.impl.ProviderXtgnServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Component
@FeignClient(value = "gdth-eureka-provider-xtgn", fallback = ProviderXtgnServiceImpl.class)
public interface ProviderXtgnService {

    @RequestMapping(value = "/getMessage", method = RequestMethod.POST)
    String getMessage();


    @RequestMapping(value = "/getUserData", method = RequestMethod.POST)
    User getUserData(@RequestParam("username") String username, @RequestParam("password") String password);

    @RequestMapping(value = "getAllUser", method = RequestMethod.POST)
    List<User> getAllUser();
}
