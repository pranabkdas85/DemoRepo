package testcases;

import org.testng.annotations.Test;

public class SampleTest {
	@Test(priority = 1, dataProviderClass = data_provider.class, dataProvider = "testlogin_dataprovider")
	public void testlogin(String username, String password) {
		// Assert.assertEquals("A","B");
		System.out.println("Login Test");
	}

	@Test(priority = 2, dependsOnMethods = "testlogin")
	public void testchangePassword() {
		System.out.println("change password Test");
	}

	@Test(priority = 3, dependsOnMethods = { "testlogin", "testchangePassword" })
	public void testlogout() {
		System.out.println("Logout Test");
	}
	// @Test

}
