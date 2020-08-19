package utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("/Users/azamattcidaev/Desktop/userData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = workbook.getSheet("Sheet1");

//        int rowNum = sheet.getPhysicalNumberOfRows();
//        for (int i = 0; i < rowNum; i++){
//            Row row = sheet.getRow(i);
//            int cellCount = row.getPhysicalNumberOfCells();
//            for(int j = 0; j < cellCount; j++){
//                System.out.print(row.getCell(j) + " | ");
//            }
//            System.out.println();
//        }
//        Iterator<Row> rowIterator = sheet.iterator();
//        while (rowIterator.hasNext()){
//            Row row = rowIterator.next();
//            Iterator<Cell> cellIterator = row.iterator();
//            while (cellIterator.hasNext()){
//                Cell cell = cellIterator.next();
//                System.out.print(cell + " | ");
//            }
//            System.out.println();
//        }

//        Sheet sheet1 = workbook.createSheet("LoginUsers");
//        Row row = sheet1.createRow(0);
//        Cell cell = row.createCell(0);
//        cell.setCellValue("First Name");
//        row.createCell(1).setCellValue("Last Name");
//        row.createCell(2).setCellValue("Phone Number");


        XSSFSheet myGroupSheet = workbook.createSheet("My Group");

        String[] header = {"First name", "email", "group name"};
        Row row2 = myGroupSheet.createRow(0);
        for (int i = 0; i < header.length; i++) {
            row2.createCell(i).setCellValue(header[i]);
        }
        Row row1 = myGroupSheet.createRow(1);
        row1.createCell(0).setCellValue("Kuba");
        row1.createCell(1).setCellValue("kuba@gmail.com");
        row1.createCell(2).setCellValue("TLA");

        FileOutputStream fileOutputStream = new FileOutputStream("/Users/azamattcidaev/Desktop/userData.xlsx");
        workbook.write(fileOutputStream);
    }
}
