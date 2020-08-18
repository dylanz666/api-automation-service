package com.github.dylanz666.util.base;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;

/**
 * @author : dylanz
 * @since : 08/05/2020
 **/
@Service
public class ExcelUtil {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Create excel
     *
     * @param sheetName: SheetName for the first sheet
     * @param title:     Head title for the sheet
     * @param content:   Content that will put to sheet
     * @param filePath:  filePath that you want to save excel
     */
    public void createExcel(String sheetName, String[] title, String[][] content, String filePath) {
        try {
            //Step 1: Create a HSSFWorkbook, this stands for the whole excel file
            Workbook wb = filePath.endsWith(".xlsx") ? new XSSFWorkbook() : new HSSFWorkbook();

            //Step 2: Add a sheet to wb, thus means we create a sheet in excel file
            Sheet sheet = wb.createSheet(sheetName);

            //Step 3: Create cell and set cell style
            CellStyle style = wb.createCellStyle();
            style.setAlignment(HorizontalAlignment.CENTER);

            Row row;
            Cell cell;
            int rowNum = 0;

            //Step 4: Add sheet's head and put title into it
            if (title != null && title.length != 0) {
                //Step 5: Create head for the sheet
                row = sheet.createRow(rowNum);
                rowNum += 1;
                for (int i = 0; i < title.length; i++) {
                    cell = row.createCell(i);
                    cell.setCellValue(title[i]);
                    cell.setCellStyle(style);
                }
            }

            //Step 6: Add content to sheet
            if (content != null && content.length != 0) {
                for (int i = 0; i < content.length; i++) {
                    row = sheet.createRow(i + rowNum);
                    for (int j = 0; j < content[i].length; j++) {
                        row.createCell(j).setCellValue(content[i][j]);
                    }
                }
            }
            logger.info("Excel workbook is created!");
            writeToFile(wb, filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * write workbook to file
     *
     * @param wb:       workbook
     * @param filePath: file path that you want to save your excel
     */
    private void writeToFile(Workbook wb, String filePath) {
        try {
            if (wb == null) {
                logger.error("Invalid Workbook!");
                return;
            }
            if (filePath == null || filePath.equals("")) {
                logger.error("Invalid filePath!");
                return;
            }
            FileOutputStream output = new FileOutputStream(filePath);
            wb.write(output);
            output.close();
            logger.info("Excel file is saved to " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}