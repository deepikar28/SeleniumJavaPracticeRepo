package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtonTest {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();

		//click in Elements Card
		WebElement Elements = driver.findElement(By.xpath("//*[@class='card-body']/h5[contains(text(), 'Elements')]"));
		Elements.click();
		Thread.sleep(1000);

		//Choose Radio Button option
		WebElement radiobtn = driver.findElement(By.xpath("//*[@id=\"item-2\"]/span[text()='Radio Button']"));

		radiobtn.click();
		Thread.sleep(1000);
		
		//Using JavaScriptExecutor scroll window
				JavascriptExecutor js = (JavascriptExecutor)(driver);
				js.executeScript("window.scrollBy(0,200)");
		
		driver.findElement(By.xpath("//label[@for=\"yesRadio\"]")).click();
		
		
		driver.findElement(By.xpath("//p[contains(text(),\"You have selected\")]/span[text()=\"Yes\"]"));
		
		driver.findElement(By.xpath("//label[@for=\"impressiveRadio\"]")).click();
		driver.findElement(By.xpath("//p[contains(text(),\"You have selected\")]/span[text()=\"Impressive\"]"));
		WebElement noradio= driver.findElement(By.xpath("//label[@for=\"noRadio\"]"));
		System.out.println(noradio.isDisplayed());
		
		WebElement radio_disable =  driver.findElement(By.xpath("//input[@id=\"noRadio\"]"));
		System.out.println(radio_disable.isDisplayed());
		System.out.println(radio_disable.isEnabled());
		System.out.println(radio_disable.isSelected());
		driver.quit();
		
	}
}
