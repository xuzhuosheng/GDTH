package com.example.gdtheurekacomsumerweb.service;


import com.example.gdtheurekacomsumerweb.service.impl.TestServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "gdth-eureka-provider-demo", fallback = TestServiceImpl.class)
public interface TestService {

    @RequestMapping("/getAccount")
    String getAccount();

}
