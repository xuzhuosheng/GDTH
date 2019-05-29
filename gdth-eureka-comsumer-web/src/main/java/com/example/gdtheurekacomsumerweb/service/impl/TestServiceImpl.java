package com.example.gdtheurekacomsumerweb.service.impl;

import com.example.gdtheurekacomsumerweb.service.TestService;
import feign.Response;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;


@Component
public class TestServiceImpl implements TestService {
    @Override
    public String getAccount() {
        return "error";
    }

    @Override
    public void exportExcel(JSONObject jsonObject) {

    }

    @Override
    public Response download(JSONObject jsonObject) {
        return null;
    }
}
