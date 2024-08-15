package elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTablesTest {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demoqa.com/webtables");
		driver.manage().window().maximize();
		
		//Finding number of Rows
		List<WebElement> rowsNumber = driver.findElements(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div"));
		int rowCount = rowsNumber.size();
		System.out.println("No of rows in this table : " + rowCount);
		
		//Finding number of Columns
		List<WebElement> columnsNumber = driver.findElements(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[1]/div/div"));

		int columnCount = columnsNumber.size();
		System.out.println("No of columns in this table : " + columnCount);
		
		Thread.sleep(1000);
		
		//Finding Cell Value of specific row and column
		WebElement celladd = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[3]/div/div[6]"));
		
		String cellvalue = celladd.getText();
		System.out.println(cellvalue);
		
		driver.findElement(By.id("searchBox")).sendKeys("Vega");
		String val = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div/div[2]")).getText();
		System.out.println(val);
		
		Assert.assertEquals(val, "Vega");
		
		driver.close();
		driver.quit();
	}

}
