package elements;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksTest {

	static WebDriver driver;
	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demoqa.com/links");
		driver.manage().window().maximize();

		driver.findElement(By.linkText("Home")).click();
		Thread.sleep(1000);

		//get window handlers as list
		List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());

		//switch to new tab
		driver.switchTo().window(browserTabs.get(1));
		Thread.sleep(2000);

		//check is it correct page opened or not (e.g. check page's title)
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		//then close tab and get back
		//		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(browserTabs.get(0));
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		Thread.sleep(3000);

		driver.switchTo().window(browserTabs.get(1));
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());


		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(browserTabs.get(0));
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		driver.findElement(By.id("dynamicLink")).click();

		//get window handlers as list
		List<String> browserTabs1 = new ArrayList<String> (driver.getWindowHandles());

		//switch to new tab
		driver.switchTo().window(browserTabs1.get(1));
		Thread.sleep(2000);

		//check is it correct page opened or not (e.g. check page's title)
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		driver.close();

	}

}
