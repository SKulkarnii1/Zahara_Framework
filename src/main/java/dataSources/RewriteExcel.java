package dataSources;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RewriteExcel {

	public static String readDataFromExcel(String file, String sheetName,
            String columnName, int srNo)
throws IOException {

FileInputStream fis = new FileInputStream(file);
try (XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

XSSFSheet sheet = workbook.getSheet(sheetName);
XSSFRow headerRow = sheet.getRow(0);
int columnCount = headerRow.getLastCellNum();

int rowCount = sheet.getPhysicalNumberOfRows();

for (int i = 1; i < rowCount; i++) {

XSSFRow row = sheet.getRow(i);
Cell srCell = row.getCell(0);   // SrNo column (0 index)

if (srCell != null && srCell.getCellType() == CellType.NUMERIC) {

int excelSrNo = (int) srCell.getNumericCellValue();

if (excelSrNo == srNo) {

for (int j = 0; j < columnCount; j++) {

if (headerRow.getCell(j).getStringCellValue()
     .equalsIgnoreCase(columnName)) {

 Cell dataCell = row.getCell(j);

 if (dataCell.getCellType() == CellType.STRING) {
     return dataCell.getStringCellValue();
 } else {
     return String.valueOf(
             (int) dataCell.getNumericCellValue());
 }
}
}
}
}
}
}

return null;
}
}