package testcases;

import org.testng.annotations.Test;

public class Testcases {

	// 2 test cases can share same set of data
	@Test(priority = 1, dataProviderClass = data_provider.class, dataProvider = "Sampledata")
	public void testa(String un, String psw, String email) {
	}

	@Test(priority = 2, dataProviderClass = data_provider.class, dataProvider = "Sampledata")
	public void testb(String un, String psw, String email) {
	}

	@Test(priority = 3, dataProviderClass = data_provider.class, dataProvider = "Sampleielsedata")
	public void testA(String un, String psw, String email) {
	}

	@Test(priority = 4, dataProviderClass = data_provider.class, dataProvider = "Sampleielsedata")
	public void testB(String un, String psw, String email) {
	}

}
