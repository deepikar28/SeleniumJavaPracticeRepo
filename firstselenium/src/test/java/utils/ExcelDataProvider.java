package utils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {
	static String  excelPath = "./excel/sample.xlsx";
	static String sheetName ="sheet1";

	@Test(dataProvider="data1")
	public  void test1(String UserName, String Password) {
		
	}

	@DataProvider(name="data1")
	public   Object[][] getData() throws Exception
	{
				Object[][] data = testData(excelPath, sheetName);

		Object[][] data1 = { { "A1", "admin1"},{ "A2", "admin2"} };	
		return data;
	}


	public  Object[][] testData(String excelPath, String sheetName ) throws Exception {

		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

		int rows = excel.getRowCount();
		int cols = excel.getColCount();

		Object data[][] = new Object[rows-1][cols];

		for(int i=1; i<rows; i++) {
			for(int j=0;j<cols; j++) {

				String cellData = excel.getCellDataString(i,j);
				data[i-1][j] = cellData;

			}
		}
		return data;
	}
}
