package waits;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import dev.failsafe.Timeout;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumWaitsTest {

	static WebDriver driver = null;

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		//		seleniumImplicitWaits();
		//		seleniumExplicitWaits();
		seleniumFluentWaits();

		teardown();
	}

	public static void seleniumImplicitWaits() {

		//Implicit wait for 10 seconds, It is applicable on entire session.
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); 

		driver.get("https://google.com");
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.sendKeys("Automation selenium");
		searchbox.sendKeys(Keys.ENTER);

		//find an element that does not exists
		driver.findElement(By.name("abcd")).click();
	}

	public static void seleniumExplicitWaits() {

		driver.get("https://google.com");
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.sendKeys("Automation selenium");
		searchbox.sendKeys(Keys.ENTER);

		//Explicit wait for 3 seconds for the element to be clickable
		//tried for 3 second(s) with 500 milliseconds interval
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		
		//find an element that does not exists
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("abc")));
		element.click();
	}

	public static void seleniumFluentWaits() throws Exception {

		driver.get("https://google.com");
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.sendKeys("Abcd");
		searchbox.sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//a[@aria-label=\"Page 2\"]")).click();
		
		//Declare and initialise a fluent wait
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		//Specify the timout of the wait
		wait.withTimeout(Duration.ofSeconds(3));
		//Sepcify polling time
		wait.pollingEvery(Duration.ofMillis(300));
		//Specify what exceptions to ignore
		wait.ignoring(NoSuchElementException.class);

		WebElement ele = driver.findElement(By.xpath("//h3[text()=\"ABCD: Any Body Can Dance\"]"));
		//This is how we specify the condition to wait on.
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();

		String text = driver.findElement(By.xpath("//h1[@id='firstHeading']/i")).getText();
		Assert.assertEquals(text, "ABCD: Any Body Can Dance");

	}

	public static void teardown () {

		driver.close();
		driver.quit();
	}


}
