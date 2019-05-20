package com.example.gdtheurekacomsumerweb.service;


import com.example.gdtheurekacomsumerweb.service.impl.ProviderXtgnServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "gdth-eureka-provider-xtgn", fallback = ProviderXtgnServiceImpl.class)
public interface ProviderXtgnService {

    @RequestMapping("/getMessage")
    String getMessage();
}
