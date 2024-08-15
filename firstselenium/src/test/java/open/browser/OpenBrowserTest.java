package open.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import config.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenBrowserTest {
	public static String browser;
	static WebDriver driver;
	static String url = "http://www.calculator.net";

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Open Browser Selenium test");

//		setBrowser();
		PropertiesFile.readPropertiesFile();// Setting browser value from config.properties file
		setBrowserConfig();
		runTest();

	}
	
//Set value of browser
	public static void setBrowser() {
		browser ="firefox";

	}
	
//Set configuration for specific Browser
	public static void setBrowserConfig() {

		if(browser.contains("firefox")) {
//			System.setProperty("webdriver.gecko.driver", "path to gecko exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.contains("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(browser.contains("safari")) {
//			System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		}
	}
	
//Run Test, perform actions
	public static void runTest() throws InterruptedException {
		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(3000);

		driver.quit();

	}

}
