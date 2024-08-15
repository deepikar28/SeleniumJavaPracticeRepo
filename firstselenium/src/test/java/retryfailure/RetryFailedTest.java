package retryfailure;

import org.testng.Assert;
import org.testng.annotations.Test;


public class RetryFailedTest {
	@Test
	public void test1() {
		System.out.println("I am in test1");
	}
	@Test
	public void test2() {
		System.out.println("I am in test2"); 
//		int i=1/0;
	}
	@Test (retryAnalyzer = listeners.RretryAnalyzer.class)
	public void test3() {
		System.out.println("I am in test3");
		Assert.assertTrue(0>1);
	}
	@Test
	public void test4() {
		System.out.println("I am in test4");

	}

}

