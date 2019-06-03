package com.example.gdtheurekaproviderutil.controller;


import net.sf.json.JSONObject;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

@RestController
public class UtilController {

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");


    /**
     * 文件上传
     *
     * @param files
     * @param request
     * @param response
     */
    @RequestMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void upload(@RequestPart(value = "files") MultipartFile[] files, HttpServletRequest request, HttpServletResponse response) {

        System.out.println(files[0].getName());

        File dest = new File("F:/xuzhuosheng/");

      /*  try {
            if (files.length > 0) {
                String contentType;
                String name;
                String orgFilename;
                long size;
                MultipartFile file;
                String suffix;
                String uuid;

                for (int i = 0, length = files.length; i < length; i++) {
                    file = files[i];
                    contentType = file.getContentType();
                    name = file.getName();
                    orgFilename = file.getOriginalFilename();
                    suffix = orgFilename.substring(orgFilename.lastIndexOf("."));
                    uuid = UUID.randomUUID().toString().replaceAll("_", "").toUpperCase();
                    file.transferTo(dest);
                }
            } else {
                System.out.println("no files");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    /**
     * 文件下载
     *
     * @param response
     * @param jsonObject
     */
    @RequestMapping(value = "/download", method = RequestMethod.POST)
    public void download(HttpServletResponse response, @RequestBody JSONObject jsonObject) {
        List<String> titleList = (List<String>) jsonObject.get("title");
        List<List<String>> dataList = (List<List<String>>) jsonObject.get("data");

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();

        HSSFRow row;
        HSSFCell cell;
        if (titleList.size() > 0) {
            row = sheet.createRow(0);
            for (int i = 0, length = titleList.size();
                 i < length;
                 i++) {
                cell = row.createCell(i);
                cell.setCellValue(titleList.get(i));
            }
        }

        if (dataList.size() > 0) {
            for (int k = 0, leng = dataList.size(); k < leng; k++) {

                row = sheet.createRow(k + 1);
                for (int j = 0, lengj = dataList.get(k).size(); j < lengj; j++) {
                    cell = row.createCell(j);
                    cell.setCellValue(dataList.get(k).get(j));
                }

            }
        }

//        导出
        try {
            ServletOutputStream outputStream = response.getOutputStream();
            response.reset();
            response.setHeader("Content-Disposition", "attachment;");
            response.setContentType("application/octet-stream;charset=utf-8");

            try {
                workbook.write(outputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }

            outputStream.flush();

            try {
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
