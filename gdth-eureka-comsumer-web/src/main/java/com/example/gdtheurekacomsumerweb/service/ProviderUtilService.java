package com.example.gdtheurekacomsumerweb.service;


import com.example.gdtheurekacomsumerweb.service.impl.ProviderUtilServiceImpl;
import feign.Response;
import net.sf.json.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "gdth-eureka-provider-util", fallback = ProviderUtilServiceImpl.class)
public interface ProviderUtilService {

    @RequestMapping("/download")
    Response download(@RequestBody JSONObject jsonObject);
}
