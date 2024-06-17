package MyFirstProject;

// Excel Util file for Login Page

import org.apache.poi.ss.usermodel.*;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	import java.io.FileInputStream;
	import java.io.IOException;

	public class ExcelUtilsData {
	    private Workbook workbook;
	    private Sheet sheet;

	    public ExcelUtilsData(String filePath, String sheetName) {
	        try {
	            FileInputStream file = new FileInputStream("D:\\Jyoti\\Selenium\\Projects\\MyFirstProject\\ExcelData.xlsx");
	            workbook = new XSSFWorkbook(file);
	            sheet = workbook.getSheet("LoginData");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public Object[][] getTestData() {
	        int rowCount = sheet.getPhysicalNumberOfRows();
	        int colCount = sheet.getRow(0).getLastCellNum();
	        Object[][] data = new Object[rowCount - 1][colCount];

	        for (int i = 1; i < rowCount; i++) {
	            Row row = sheet.getRow(i);
	            for (int j = 0; j < colCount; j++) {
	                data[i - 1][j] = row.getCell(j).toString();
	            }
	        }
	        return data;
	    }
	}

