package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelPath, String sheetName) throws Exception {
		
		workbook = new XSSFWorkbook(excelPath);
		sheet = workbook.getSheet(sheetName);

	}

	public int getRowCount() throws Exception  {

		int row_count = sheet.getPhysicalNumberOfRows();
//		System.out.println("no of rows in sheet: " + row_count);
		return row_count;
	}

	public  int getColCount() throws Exception  {

		int col_count = sheet.getRow(0).getPhysicalNumberOfCells();
//		System.out.println("no of rows in sheet: " + col_count);
		return col_count;
	}

	public  String getCellDataString(int rowNum, int colNum) throws Exception {

		String celldata = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
//		System.out.println(celldata);
		return celldata;

	}

	public  int getCellDataNumber(int rowNum, int colNum) throws Exception {

		double celldata = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
//		System.out.println(celldata);
		return (int) celldata;

	}


}
