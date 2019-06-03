package com.example.gdtheurekacomsumerweb.controller;


import com.example.gdtheurekacomsumerweb.service.ProviderUtilService;
import feign.Response;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * 工具类
 * 对接ProviderUtilService
 * 对应provider：gdth-eureka-provider-util
 */

@RestController
public class UtilController {


    @Autowired
    ProviderUtilService providerUtilService;


    /**
     * 上传文件方法
     *
     * @param files
     * @return
     */
    @RequestMapping(value = "/uploadFiles", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadFiles(@RequestParam(value = "files", required = false) MultipartFile[] files) {
        System.out.println("this is uploadFiles function");

        try {

            if (files.length > 0) {

                String fileDirStr = "F:/xuzhuosheng/";
                File fileDir = new File(fileDirStr);
                if (!fileDir.isDirectory()) {
                    fileDir.mkdir();
                    System.out.println("create new file");
                }
                long time;
                MultipartFile file;
                File targetfile;
                String fileName;
                for (int i = 0, length = files.length; i < length; i++) {
                    file = files[i];
                    fileName = file.getOriginalFilename();
                    time = System.currentTimeMillis();
                    targetfile = new File(fileDirStr, time + "_" + fileName);
                    file.transferTo(targetfile);
                }
            } else {
                System.out.println("no files");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    /**
     * 下载文件调用方法
     *
     * @return
     */
    @RequestMapping(value = "/downloadFiles", method = RequestMethod.POST)
    public ResponseEntity<byte[]> downloadFiles() {

//        测试
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
