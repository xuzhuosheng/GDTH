package com.example.gdtheurekacomsumerweb.service.impl;

import com.example.gdtheurekacomsumerweb.service.ProviderXtgnService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;


@Component
public class ProviderXtgnServiceImpl implements ProviderXtgnService {

    @RequestMapping("/toError")
    public String getMessage() {
        return "error";
    }
}
