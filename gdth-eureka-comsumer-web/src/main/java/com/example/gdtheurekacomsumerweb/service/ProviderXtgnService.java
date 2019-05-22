package com.example.gdtheurekacomsumerweb.service;


import com.example.gdtheurekacomsumerweb.entity.User;
import com.example.gdtheurekacomsumerweb.service.impl.ProviderXtgnServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "gdth-eureka-provider-xtgn", fallback = ProviderXtgnServiceImpl.class)
public interface ProviderXtgnService {

    @RequestMapping("/getMessage")
    String getMessage();


    @RequestMapping("/getUserData")
    User getUserData(@RequestParam("username") String username, @RequestParam("password") String password);
}
