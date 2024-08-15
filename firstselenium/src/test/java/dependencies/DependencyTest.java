package dependencies;

import org.testng.annotations.Test;

public class DependencyTest {
	
	@Test(dependsOnMethods = {"test2", "test3"}, priority = 0) //will check for the status of test2 and test3 first then execute
	public void test1() {
		System.out.println("I am in test1");
	}
	
	@Test (dependsOnGroups = {"hotfix"}) //depends on group
	public void test2() {
		System.out.println("I am in test2"); // will execute before test3
	}

	@Test (priority = 0)
	public void test3() {
		System.out.println("I am in test3");
	}
	
	@Test (groups = {"hotfix"})
	public void test4() {
		System.out.println("I am in test4");
	
	
}
}
