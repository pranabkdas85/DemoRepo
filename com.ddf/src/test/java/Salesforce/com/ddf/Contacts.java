package Salesforce.com.ddf;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

public class Contacts extends base.Base {
	Xls_Reader xls;

	@Test(dataProvider = "getData")
	public void Contacts_dropdown(Hashtable<String, String> data) throws IOException {
		testCaseName = "Contacts";
		test = rep.startTest("Contacts_dropdown");
		test.log(LogStatus.INFO, data.toString());
		if (!DataUtil.isRuunnable(testCaseName, xls) || data.get("Runmode").toUpperCase().equals("N")) {
			test.log(LogStatus.SKIP, testCaseName + ": The  test Case is Skipped as Run Mode is N");
			throw new SkipException(testCaseName + ": The  test Case is Skipped as Run Mode is N");
		}
		test.log(LogStatus.INFO, "Starting the Test");

	}

	@BeforeMethod
	public void initial() {

		softassert = new SoftAssert();

	}

	@AfterMethod
	public void quit() {
		try {
			softassert.assertAll();
		} catch (Error e) {
			test.log(LogStatus.FAIL, e.getMessage());
		}
		rep.endTest(test);
		rep.flush();
	}

	@DataProvider
	public Object[][] getData() {
		init();
		Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir") + "\\Data.xlsx");
		return DataUtil.getTestData(xls, "TestC");
	}

}