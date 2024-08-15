package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Buttons_ClickRightClickDoubleClickTest {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {


		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demoqa.com/buttons");
		driver.manage().window().maximize();


		Actions action = new Actions(driver);

		//Single Click
		WebElement clickme = driver.findElement(By.xpath("//button[text()=\"Click Me\"]"));

		clickme.click();
		//Verify dynamic message
		String click_msg= driver.findElement(By.id("dynamicClickMessage")).getText();
		Assert.assertEquals(click_msg, "You have done a dynamic click");

		// Right click 
		WebElement right_clickme = driver.findElement(By.id("rightClickBtn"));
		action.contextClick(right_clickme).perform();
		Thread.sleep(1000);
		//Verify dynamic message 
		String right_click_msg= driver.findElement(By.id("rightClickMessage")).getText();
		Assert.assertEquals(right_click_msg, "You have done a right click");

		
		//Double Click 
		WebElement double_clickme = driver.findElement(By.id("doubleClickBtn"));
		action.doubleClick(double_clickme).perform();
		//Verify dynamic message
		String double_click_msg= driver.findElement(By.id("doubleClickMessage")).getText();
		Assert.assertEquals(double_click_msg, "You have done a double click");
		
		// Closing the driver instance
		driver.close();

	}

}
