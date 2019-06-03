package com.example.gdtheurekacomsumerweb.service;


import com.example.gdtheurekacomsumerweb.service.impl.ProviderUtilServiceImpl;
import com.example.gdtheurekacomsumerweb.util.FeignMultipartSupportConfig;
import feign.Response;
import net.sf.json.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Component
@FeignClient(value = "gdth-eureka-provider-util", configuration = FeignMultipartSupportConfig.class, fallback = ProviderUtilServiceImpl.class)
public interface ProviderUtilService {

    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Object upload(@RequestPart(value = "files") MultipartFile[] files);

    @RequestMapping("/download")
    Response download(@RequestBody JSONObject jsonObject);


}
