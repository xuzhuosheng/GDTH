package com.example.gdtheurekacomsumerweb.service.impl;

import com.example.gdtheurekacomsumerweb.service.TestService;
import org.springframework.stereotype.Component;


@Component
public class TestServiceImpl implements TestService {
    @Override
    public String getAccount() {
        return "error";
    }
}
