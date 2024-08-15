package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxTest {
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

		//Choose Check Box option
		WebElement textbox = driver.findElement(By.xpath("//*[@id=\"item-1\"]/span[text()='Check Box']"));

		textbox.click();
		Thread.sleep(1000);
		//Verify page header
		driver.findElement(By.xpath("//h1[@class='text-center' and text()='Check Box']"));
		Thread.sleep(1000);
		//select Home check box
		WebElement home = driver.findElement(By.xpath("//label[@for=\"tree-node-home\"]"));
		home.click();

		driver.findElement(By.xpath("//div[@id=\"result\"]/span[contains(text(),\"You have selected :\")]"));

		//verify Home check box is checked
		driver.findElement(By.xpath("//label[@for=\"tree-node-home\"]/span/*[local-name()='svg' and @class=\"rct-icon rct-icon-check\"]/*[local-name()='path']"));
		WebElement home_checkbx =  driver.findElement(By.xpath("//input[@id=\"tree-node-home\"]"));
		
		System.out.println(home_checkbx.isSelected());
		
		//Un-select Home check box
		driver.findElement(By.xpath("//label[@for=\"tree-node-home\"]")).click();

		Thread.sleep(1000);
		//verify Home check box is Un-checked
		driver.findElement(By.xpath("//label[@for=\"tree-node-home\"]/span/*[local-name()='svg' and @class=\"rct-icon rct-icon-uncheck\"]/*[local-name()='path']"));
		Thread.sleep(1000);
		
		System.out.println(home_checkbx.isSelected());

		//Expand from > button
		driver.findElement(By.xpath("//button[@class=\"rct-collapse rct-collapse-btn\" and @title=\"Toggle\"]")).click();
		Thread.sleep(1000);
		//select Desktop check box
		driver.findElement(By.xpath("//label[@for=\"tree-node-desktop\"]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//label[@for=\"tree-node-desktop\"]/span/*[local-name()='svg' and @class=\"rct-icon rct-icon-check\"]/*[local-name()='path']"));
		Thread.sleep(1000);

		driver.findElement(By.xpath("//label[@for=\"tree-node-home\"]/span/*[local-name()='svg' and @class=\"rct-icon rct-icon-half-check\"]/*[local-name()='path']"));
		Thread.sleep(1000);

		//expand Desktop by clicking on >

		driver.findElement(By.xpath("//button[@class=\"rct-collapse rct-collapse-btn\" and @title=\"Toggle\"]/*[local-name()='svg' and @class=\"rct-icon rct-icon-expand-close\"]")).click();
		Thread.sleep(1000);

		//Verify Notes and Commands are Checked
		driver.findElement(By.xpath("//label[@for=\"tree-node-notes\"]/span/*[local-name()='svg' and @class=\"rct-icon rct-icon-check\"]/*[local-name()='path']"));
		Thread.sleep(1000);

		driver.findElement(By.xpath("//label[@for=\"tree-node-commands\"]/span/*[local-name()='svg' and @class=\"rct-icon rct-icon-check\"]/*[local-name()='path']"));
		Thread.sleep(2000);

		//uncheck Notes
		driver.findElement(By.xpath("//label[@for=\"tree-node-notes\"]")).click();
		Thread.sleep(1000);

		//Verify Desktop Half Check
		driver.findElement(By.xpath("//label[@for=\"tree-node-desktop\"]/span/*[local-name()='svg' and @class=\"rct-icon rct-icon-half-check\"]/*[local-name()='path']"));
		Thread.sleep(1000);

		//Verify Home Half Check
		driver.findElement(By.xpath("//label[@for=\"tree-node-home\"]/span/*[local-name()='svg' and @class=\"rct-icon rct-icon-half-check\"]/*[local-name()='path']"));
		Thread.sleep(1000);

		//Uncheck Commands
		driver.findElement(By.xpath("//label[@for=\"tree-node-commands\"]")).click();
		Thread.sleep(1000);

		//Verify Desktop Uncheck
		driver.findElement(By.xpath("//label[@for=\"tree-node-desktop\"]/span/*[local-name()='svg' and @class=\"rct-icon rct-icon-uncheck\"]/*[local-name()='path']"));
		Thread.sleep(1000);
		//Verify Home Half Check
		driver.findElement(By.xpath("//label[@for=\"tree-node-home\"]/span/*[local-name()='svg' and @class=\"rct-icon rct-icon-uncheck\"]/*[local-name()='path']"));
		Thread.sleep(1000);

		//select Documents check box
		driver.findElement(By.xpath("//label[@for=\"tree-node-documents\"]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//label[@for=\"tree-node-documents\"]/span/*[local-name()='svg' and @class=\"rct-icon rct-icon-check\"]/*[local-name()='path']"));
		Thread.sleep(1000);
		//select Downloads check box
		driver.findElement(By.xpath("//label[@for=\"tree-node-downloads\"]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//label[@for=\"tree-node-downloads\"]/span/*[local-name()='svg' and @class=\"rct-icon rct-icon-check\"]/*[local-name()='path']"));
		Thread.sleep(1000);

				//Expand through +
				driver.findElement(By.xpath("//button[@class=\"rct-option rct-option-expand-all\" and @title=\"Expand all\"]")).click();
				Thread.sleep(2000);
				//collapse through -
						driver.findElement(By.xpath("//button[@class=\"rct-option rct-option-collapse-all\" and @title=\"Collapse all\"]")).click();
						Thread.sleep(2000);
				//Expand from > button
				driver.findElement(By.xpath("//button[@class=\"rct-collapse rct-collapse-btn\" and @title=\"Toggle\"]")).click();
						Thread.sleep(2000);

//		//Using JavaScriptExecutor scroll window
//		JavascriptExecutor js = (JavascriptExecutor)(driver);
//		js.executeScript("window.scrollBy(0,200)");

		Thread.sleep(1000);
		driver.close();

	}

}
