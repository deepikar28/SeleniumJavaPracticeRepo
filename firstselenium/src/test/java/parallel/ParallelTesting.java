package parallel;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ParallelTesting {
	String URL = "https://opensource-demo.orangehrmlive.com";
	ChromeDriver driver = null;
	
//run single method in multithreaded //threadPoolSize = 3, invocationCount = 3, timeOut = 1000
	
	@Test
	public void Test1() throws Exception {

		System.out.println("In test1 |"+ Thread.currentThread().getId());
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		Thread.sleep(3000);
		driver.close();
	}

	@Test
	public void Test2() throws Exception {
		System.out.println("In test2 |"+ Thread.currentThread().getId());
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(URL);
		Thread.sleep(3000);
		driver.close();
	}

	@Test
	public void Test3() {
		System.out.println("In test3 |"+ Thread.currentThread().getId());


	}

}
