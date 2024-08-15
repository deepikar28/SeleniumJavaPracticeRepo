package google.search;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

	public static void main(String[] args) throws Exception {

		googleSearch();
	}


	static void googleSearch() throws Exception{
		WebDriver driver = new ChromeDriver();

		driver.get("https://google.com");

		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.sendKeys("Automation selenium");
		
		Thread.sleep(2000);
		searchbox.sendKeys(Keys.ENTER);

		driver.close();

	}
}
