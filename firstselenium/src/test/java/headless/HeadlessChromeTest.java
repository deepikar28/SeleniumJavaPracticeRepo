package headless;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessChromeTest {
	static WebDriver driver = null;

	public static void main(String[] args) {

		headlessChrome();
		teardown();
	}

	public static void headlessChrome() {

		ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
		options.addArguments("--incognito");
		//		options.addArguments("test-type");
		//	    options.addArguments("start-maximized");
		options.addArguments("enable-popup-blocking");
		driver = new ChromeDriver(options);

		driver.get("https://google.com");

		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.sendKeys("Automation selenium");
		searchbox.sendKeys(Keys.ENTER);

	}

	public static void teardown() {
		System.out.println("Headless Test Completed");
		driver.close();
		driver.quit();

	}
}
