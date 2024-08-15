package utils;

public class ExcelDemo {
	public static void main(String[] args) {
		String  excelPath = "./excel/API_test_data.xlsx";
		String sheetName ="GetUser";

		try {
			ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
			excel.getRowCount();
			excel.getCellDataString(0,0);
			excel.getCellDataNumber(1,2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
