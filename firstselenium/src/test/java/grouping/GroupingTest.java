package grouping;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

@Test(groups = {"AllTest"})
public class GroupingTest {
	
	@Test(groups = {"sanity"}) // grouping of tests
	public void test1() {
		
		System.out.println("this is test1");
	}
	
	@Test(groups = {"sanity","smoke"}) // grouping of tests -- same test exists in more than one Group
	public void test2() {
		
		System.out.println("this is test2");
	}
	
	@Test(groups = {"sanity","regression"})
	public void test3() {
		
		System.out.println("this is test3");
	}
	
	@Test(groups = {"windows.regression"})
	public void test4() {
		
		System.out.println("this is test4");
	}
	
	@Test(groups = {"linux.regression"})
	public void test5() {
		
		System.out.println("this is test5");
	}

}
