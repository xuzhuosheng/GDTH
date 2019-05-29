package com.example.gdtheurekaproviderdemo.controller;


import com.example.gdtheurekaproviderdemo.entity.User;
import com.example.gdtheurekaproviderdemo.service.UserService;
import net.sf.json.JSONObject;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/toTest")
    public String toTest() {
        List<User> userList = new ArrayList<>();
        try {
            userList = userService.getData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList.get(0).getAccount();
    }


    @RequestMapping("/getAccount")
    public String getAccount() {
        List<User> userList = new ArrayList<>();
        System.out.println("this is demo ");
        String name = "";

        try {
            userList = userService.getData();
            name = userList.get(0).getAccount();
            System.out.println(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return name;
    }


    @RequestMapping("/download")
    public void download(HttpServletResponse response,@RequestBody JSONObject jsonObject) {
        List<String> title = (List<String>) jsonObject.get("title");

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(1);
        cell.setCellValue(title.get(1));

        try {
            String fileName = "test.xls";

//            String fileName = "TEST_" + System.currentTimeMillis() + ".xls";
            ServletOutputStream outputStream = response.getOutputStream();
            response.reset();
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
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
