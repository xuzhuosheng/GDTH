package com.example.gdtheurekacomsumerweb.controller;


import com.example.gdtheurekacomsumerweb.service.ProviderUtilService;
import feign.Response;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UtilController {


    @Autowired
    ProviderUtilService providerUtilService;


    @RequestMapping("/downloadFiles")
    public ResponseEntity<byte[]> downloadFiles() {

        List<String> title = new ArrayList<>();
        title.add("aaa");
        title.add("bbb");
        title.add("ccc");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title", title);


        ResponseEntity<byte[]> entity = null;
        InputStream inputStream = null;

        String fileName = "test_" + System.currentTimeMillis() + ".xls";
        try {

            Response response = providerUtilService.download(jsonObject);
            Response.Body body = response.body();
            inputStream = body.asInputStream();
            byte[] b = new byte[inputStream.available()];
            inputStream.read(b);
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName);
            headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

            entity = new ResponseEntity<byte[]>(b, headers, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return entity;

    }
}
