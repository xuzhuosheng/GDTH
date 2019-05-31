package com.example.gdtheurekacomsumerweb.service.impl;


import com.example.gdtheurekacomsumerweb.service.ProviderUtilService;
import feign.Response;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Component
public class ProviderUtilServiceImpl implements ProviderUtilService {

    @Override
    public Object upload(MultipartFile[] files) {
        return null;
    }

    @Override
    public Response download(JSONObject jsonObject) {
        return null;
    }
}
