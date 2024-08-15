package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class seleniumtest {
	static String browser;
	static WebDriver driver;


	public static void main(String[] args) throws InterruptedException {

		setBrowser();
		setBrowserConfig();
		runTest();

	}

	public static void setBrowser() {
		browser ="chrome";

	}

	public static void setBrowserConfig() {

		if(browser.contains("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/deepika/eclipse-workspace/FirstSeleniumJava/drivers/geckodriver");
			driver = new FirefoxDriver();
		}
		else if(browser.contains("chrome")) {
//			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "/Users/deepika/eclipse-workspace/FirstSeleniumJava/drivers/chromedriver");
			driver = new ChromeDriver();
		}
	}

	public static void runTest() throws InterruptedException {
		driver.get("https://google.com");
		Thread.sleep(3000);

		driver.quit();

	}

}
