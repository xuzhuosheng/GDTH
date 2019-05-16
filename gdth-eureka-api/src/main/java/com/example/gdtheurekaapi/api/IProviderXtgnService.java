package com.example.gdtheurekaapi.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;


@Component
@FeignClient("gdth-eureka-provider-xtgn")
public interface IProviderXtgnService {

    @RequestMapping("/doExpExcel")
    void expExcel();
}
