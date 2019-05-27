package com.example.gdtheurekaproviderutil.controller;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
public class UtilController {

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");


    @RequestMapping("/expExcel")
    public void expExcel(List<String> titleList, List<List<String>> dataList, HttpServletResponse response) {

        System.out.println("expExcel");
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


//        HSSFRow dataRow;
        if (dataList.size() > 0) {
            for (int k = 0, leng = dataList.size(); k < leng; k++) {

                row = sheet.createRow(k + 1);
                for (int j = 0, lengj = dataList.get(k).size(); j < lengj; j++) {
                    cell = row.createCell(j);
                    cell.setCellValue(dataList.get(k).get(j));
                }

            }
        }

        //导出
        try {

            String fileName = "TEST_" + System.currentTimeMillis() + ".xls";
            OutputStream outputStream = response.getOutputStream();
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
