package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenImagesTest {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demoqa.com/broken");
		driver.manage().window().maximize();


		//Verify Valid Image
		String valid_image_url =  driver.findElement(By.xpath("//div/img[1]")).getAttribute("src");

		System.out.println(valid_image_url);

		//Verify Broken Image
		String broken_image_url =  driver.findElement(By.xpath("//div/img[2]")).getAttribute("src");

		System.out.println(broken_image_url);


		driver.quit();
	}

}
