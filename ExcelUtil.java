package MyFirstProject;

	import org.apache.poi.ss.usermodel.DataFormatter;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	import java.io.FileInputStream;
	import java.io.IOException;

public class ExcelUtil {
	private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;

    public static Object[][] getTestData(String excelPath, String sheetName) {
        Object[][] data = null;
        try {
            FileInputStream fis = new FileInputStream("D:\\Jyoti\\Selenium\\Projects\\MyFirstProject\\ExcelData.xlsx");
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet("RegistrationData");
            
            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
            
            data = new Object[rowCount - 1][colCount];
            DataFormatter formatter = new DataFormatter();

            for (int i = 1; i < rowCount; i++) {
                if (sheet.getRow(i) != null) {
                    for (int j = 0; j < colCount; j++) {
                        data[i - 1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));
                    }
                }
            }

            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
