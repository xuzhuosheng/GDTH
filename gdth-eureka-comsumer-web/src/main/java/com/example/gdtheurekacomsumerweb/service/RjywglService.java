package com.example.gdtheurekacomsumerweb.service;


import com.example.gdtheurekacomsumerweb.entity.Rjywgl;
import com.example.gdtheurekacomsumerweb.service.impl.RjywglServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Component
@FeignClient (value = "gdth-eureka-provider-ywgn", fallback = RjywglServiceImpl.class)
public interface RjywglService {

    @RequestMapping (value = "saveRjywjl", method = RequestMethod.POST)
    Map<String, String> saveRjywjl(@RequestParam ("title") String title, @RequestParam ("type") String type,
                                   @RequestParam ("content") String content,
                                   @RequestParam ("scripttxt") String scripttxt,
                                   @RequestParam ("bz") String bz, @RequestParam ("creator") String creator);

    @RequestMapping (value = "getData", method = RequestMethod.POST)
    List<Rjywgl> getData();
}
