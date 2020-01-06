package org.javaboy.vhr.utils;

import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.javaboy.vhr.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class POIUtils {
    public static ResponseEntity<byte[]> employee2Excel(List<Employee> list) {
        //1.创建一个Excel文档
        HSSFWorkbook workbook = new HSSFWorkbook();
        //2.创建文档摘要
        workbook.createInformationProperties();
        //3.获取并配置文档摘要信息
        DocumentSummaryInformation docInfo = workbook.getDocumentSummaryInformation();
        //文档类别
        docInfo.setCategory("员工信息");
        //文档管理员
        docInfo.setManager("kafun");
        //设置公司信息
        docInfo.setCompany("广东用友");
        //4.获取文档摘要信息
        SummaryInformation sumInfo = workbook.getSummaryInformation();
        //文档标题
        sumInfo.setTitle("员工信息表");
        //文档作者
        sumInfo.setAuthor("kafun");
        //文档备注
        sumInfo.setComments("本文档由 kafun 提供");
        //5.创建样式
        //创建标题的样式
        HSSFCellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        HSSFSheet sheet = workbook.createSheet("员工信息表");
        //6.创建标题行
        HSSFRow r0 = sheet.createRow(0);
        HSSFCell c0 = r0.createCell(0);
        c0.setCellValue("编号");
        c0.setCellStyle(headerStyle);
        HSSFCell c1 = r0.createCell(1);
        HSSFCell c2 = r0.createCell(2);
        HSSFCell c3 = r0.createCell(3);
        HSSFCell c4 = r0.createCell(4);
        HSSFCell c5 = r0.createCell(5);
        HSSFCell c6 = r0.createCell(6);
        HSSFCell c7 = r0.createCell(7);
        HSSFCell c8 = r0.createCell(8);
        HSSFCell c9 = r0.createCell(9);
        HSSFCell c10 = r0.createCell(10);
        HSSFCell c11 = r0.createCell(11);
        HSSFCell c12 = r0.createCell(12);
        HSSFCell c13 = r0.createCell(13);
        HSSFCell c14 = r0.createCell(14);
        HSSFCell c15 = r0.createCell(15);
        HSSFCell c16 = r0.createCell(16);
        HSSFCell c17 = r0.createCell(17);
        HSSFCell c18 = r0.createCell(18);
        HSSFCell c19 = r0.createCell(19);
        HSSFCell c20 = r0.createCell(20);
        HSSFCell c21 = r0.createCell(21);
        HSSFCell c22 = r0.createCell(22);
        HSSFCell c23 = r0.createCell(23);



















        return null;
    }
}
