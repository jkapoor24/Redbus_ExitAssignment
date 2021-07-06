package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;

//This method is to set the File path and to open the Excel file, it fetches data from Excel sheets and return data in the form of object array.

	public static Object[][] ExcelFile(String Path, String SheetName) throws Exception {
		Object[][] arrayExcelData = null;
		try {
			// Open the Excel file

			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			XSSFRow row = ExcelWSheet.getRow(0);
			int totalNoOfCols = row.getLastCellNum();
			int totalNoOfRows = ExcelWSheet.getLastRowNum() + 1;
			arrayExcelData = new String[totalNoOfRows - 1][totalNoOfCols];

			for (int i = 1; i < totalNoOfRows; i++) {
				for (int j = 0; j < totalNoOfCols; j++) {
					DataFormatter formatter = new DataFormatter();
					Object CellData = formatter.formatCellValue(ExcelWSheet.getRow(i).getCell(j));
					arrayExcelData[i - 1][j] = CellData;
				}
			}
		} catch (Exception e) {
			throw (e);
		}
		return arrayExcelData;
	}
}
