package dataSources;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Employees_Excel {
	public static void main(String[] args) throws IOException {

        // 1. Load Excel file
        FileInputStream fis = new FileInputStream("D:\\Automtion\\ESCT_Framwork_Explained\\TestData.xlsx");

        // 2. Create Workbook object
        Workbook workbook = new XSSFWorkbook(fis);

        // 3. Get first sheet
        Sheet sheet = workbook.getSheetAt(0);

        // 4. Loop through rows (skip header row)
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            Row row = sheet.getRow(i);

            // 5. Read FirstName (Column 0)
            String firstName = row.getCell(0).getStringCellValue();

            // 6. Read LastName (Column 1)
            String lastName = row.getCell(1).getStringCellValue();

            // 7. Print values
            System.out.println("First Name: " + firstName + 
                               " | Last Name: " + lastName);
        }

        // 8. Close workbook
        workbook.close();
        fis.close();
    }

}
