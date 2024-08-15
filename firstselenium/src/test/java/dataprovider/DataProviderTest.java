package dataprovider;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExcelUtils;

public class DataProviderTest {
	String URL = "https://opensource-demo.orangehrmlive.com";
	ChromeDriver driver = null;
	By user_name = By.xpath("//input[@name='username' and @placeholder='Username']");
	By pass_word = By.xpath("//input[@name='password' and @placeholder='Password']");
	By login_button = By.xpath("//button[text()=\" Login \"]");
	
	By invalid_cred = By.xpath("//p[text()=\"Invalid credentials\"]");
	
	static String  excelPath = "./excel/sample.xlsx";
	static String sheetName ="Sheet1";

	@BeforeTest
	public void browserSetup() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(URL);
		Thread.sleep(2000);
	}


	@Test(dataProvider = "loginInvalidExcel", priority = 1)
	public void login1(String username, String password, String exp_error) throws Exception {
		Thread.sleep(2000);
		driver.findElement(user_name).sendKeys(username);
		driver.findElement(pass_word).sendKeys(password);
		driver.findElement(login_button).click();
		Thread.sleep(2000);
		
		WebElement error = driver.findElement(invalid_cred);
		String act_error = error.getText();
		
		Assert.assertEquals(act_error, exp_error);
		
	}
	
	@Test(dataProvider = "loginInvalid", priority = 0)
	public void login2(String username, String password, String exp_error) throws Exception {
		Thread.sleep(2000);
		driver.findElement(user_name).sendKeys(username);
		driver.findElement(pass_word).sendKeys(password);
		driver.findElement(login_button).click();
		Thread.sleep(2000);
		
		WebElement error = driver.findElement(invalid_cred);
		String act_error = error.getText();
		
		Assert.assertEquals(act_error, exp_error);
		
	}

	@AfterTest
	public void teardown() {
		    driver.close();
		    driver.quit();

	}
	
	
	@DataProvider(name="loginInvalid")
	public Object[][] logintestdata(){
		Object[][] ids= {{"Admin", "123","Invalid credentials"}};
		return ids;
		
	}
	
	@DataProvider(name="loginInvalidExcel")
	public   Object[][] getData() throws Exception
	{
		Object[][] data = testData(excelPath, sheetName);
		return data;
	}


	@Test
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
