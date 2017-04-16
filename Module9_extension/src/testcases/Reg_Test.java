package testcases;

import org.testng.annotations.Test;

public class Reg_Test {

	@Test(dataProviderClass = data_provider.class, dataProvider = "Reg_test_dataprovider")
	public void doRegistration(String username, String Password, String email) {
		System.out.println(username + Password + email);
	}
}
