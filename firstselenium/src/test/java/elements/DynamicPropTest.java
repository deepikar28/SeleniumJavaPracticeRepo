package elements;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicPropTest {

	static WebDriver driver= null;

	public static void main(String[] args) throws Exception {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demoqa.com/dynamic-properties");
		driver.manage().window().maximize();

//		WebElement col_change =  driver.findElement(By.xpath("//button[@id=\"colorChange\"]"))	;
//		String s = col_change.getCssValue("color");
//		// convert rgba to hex
//		String c = Color.fromString(s).asHex();
//		System.out.println("Color is :" + s);
//		System.out.println("Hex code for color:" + c);
//		
//		//Verify Button is enable after 5 seconds
//		Boolean before_st = driver.findElement(By.xpath("//button[@id=\"enableAfter\"]")).isEnabled()	;
//		System.out.println(before_st);
//		Thread.sleep(5000);
//		Boolean after_st = driver.findElement(By.xpath("//button[@id=\"enableAfter\"]")).isEnabled()	;
//		System.out.println(after_st);
//
//		//Verify Button Text change color after 5 seconds
//		driver.findElement(By.xpath("//button[@id=\"colorChange\"]"))	;
//		String s1 = col_change.getCssValue("color");
//		// convert rgba to hex
//		String c1 = Color.fromString(s1).asHex();
//		System.out.println("Color is :" + s1);
//		System.out.println("Hex code for color:" + c1);
//		
//		//Verify Button is visible after 5 seconds
//		Boolean bt = driver.findElement(By.xpath("//button[@id=\"visibleAfter\"]")).isDisplayed()	;
//		System.out.println(bt);
//		
		
		
		Wait<WebDriver> wait
        = new FluentWait<WebDriver>(driver)
              .withTimeout(Duration.ofSeconds(4))
              .pollingEvery(Duration.ofSeconds(2))
              .ignoring(TimeoutException.class);

    try {
        // Wait until the element with ID "my_element"
        // is clickable
        WebElement element = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.id("visibleAfter")));

        // Once the element is clickable, perform
        // desired actions
        element.click();
        System.out.println(
            "Element clicked successfully!");
    }
    catch (TimeoutException e) {
        System.out.println(
            "Timed out waiting for element to be clickable..");
    }

		driver.quit();
	}

}
