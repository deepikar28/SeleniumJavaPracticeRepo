package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextBoxTest {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();
		
		WebElement Elements = driver.findElement(By.xpath("//*[@class='card-body']/h5[contains(text(), 'Elements')]"));
		Elements.click();
		Thread.sleep(1000);
		
		WebElement elements = driver.findElement(By.xpath("//*[@class=\"header-text\" and text()=\"Elements\"]"));

		String classname = driver.findElement(By.xpath("//*[@class=\"element-group\"]/div[@class=\"element-list collapse show\"]")).getAttribute("class");
		
		if (classname.contains("element-list collapse show")) {
			System.out.println("Elements list is expended");
		}
		else {System.out.println("Elements list is collapsed");}
		
		WebElement textbox = driver.findElement(By.xpath("//*[@id=\"item-0\"]/span[text()='Text Box']"));
	
		textbox.click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//h1[@class='text-center' and text()='Text Box']"));
		Thread.sleep(1000);
		
		
		WebElement fullname= driver.findElement(By.xpath("//input[@id=\"userName\" and @placeholder=\"Full Name\"]"));
		fullname.sendKeys("Deepika Rani");
		Thread.sleep(1000);
		
		
		WebElement emailid= driver.findElement(By.xpath("//input[@id=\"userEmail\" and @placeholder=\"name@example.com\"]"));
		emailid.sendKeys("test@gmail.com");
		Thread.sleep(1000);
		
		//Using JavaScriptExecutor scroll window
		JavascriptExecutor js = (JavascriptExecutor)(driver);
		js.executeScript("window.scrollBy(0,200)");
		
		
		driver.findElement(By.id("submit")).click();
		Thread.sleep(1000);
		driver.close();
		
		
		
	}

}
