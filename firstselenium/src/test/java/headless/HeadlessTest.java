package headless;

import org.htmlunit.BrowserVersion;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HeadlessTest {
	public static void main(String[] args) {
		//create object of HTmlUnitDriver class
//		HtmlUnitDriver driver = new HtmlUnitDriver();
		
		//create object of HtmlUnitDriver class for specific Browser using Browserversion
		HtmlUnitDriver driver = new HtmlUnitDriver(BrowserVersion.EDGE);
		
		driver.get("https://google.com");
		System.out.println("Title is : " + driver.getTitle());
		
		//check on which Browser tests are running
		System.out.println(driver.getBrowserVersion());
		System.out.println(driver.getCurrentWindow());
		driver.quit();

	}
}
