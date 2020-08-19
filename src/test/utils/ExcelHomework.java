package utils;

import base.BaseTest;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pojos.UserTLA;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelHomework extends BaseTest {

    public static void main(String[] args) throws IOException {
        UserTLA users;
        FileInputStream fileInputStream = new FileInputStream("/Users/azamattcidaev/Desktop/userData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        String []  header = {"First name", "Last name", "phone num", "email", "role"};
        String []  role   = {"Student", "Instructor", "Mentor"};

        Sheet usersSheet = workbook.createSheet("Users");
        Row row = usersSheet.createRow(0);

        int count = 0;
        for (int i = 0; i < header.length; i++) {
            row.createCell(i).setCellValue(header[i]);
            for(int j = 0; j < 20; j++){
                if(count == 3){
                    count = 0;
                }
                users = new UserTLA();
                Row row1 = usersSheet.createRow(j + 1);
                row1.createCell(0).setCellValue(users.getFirstName());
                row1.createCell(1).setCellValue(users.getLastName());
                row1.createCell(2).setCellValue(users.getPhoneNumber());
                row1.createCell(3).setCellValue(users.getEmail());
                row1.createCell(4).setCellValue(role[count]);
                count++;
            }
        }

        FileOutputStream fileOutputStream = new FileOutputStream("/Users/azamattcidaev/Desktop/userData.xlsx");
        workbook.write(fileOutputStream);

    }

}
