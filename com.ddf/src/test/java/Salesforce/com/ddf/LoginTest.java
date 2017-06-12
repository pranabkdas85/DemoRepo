package Salesforce.com.ddf;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Hashtable;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import base.Base;

public class LoginTest extends Base {
	Xls_Reader xls;

	@BeforeMethod
	public void initial() {
		softassert = new SoftAssert();
	}

	@Test(dataProvider = "getData", priority = 1)
	public void LoginTestscenarios(Hashtable<String, String> data) throws IOException {
		testCaseName = "LoginTestscenarios";
		test = rep.startTest("LoginTestscenarios");
		test.log(LogStatus.INFO, data.toString());
		if (!DataUtil.isRuunnable(testCaseName, xls) || data.get("Runmode").toUpperCase().equals("N")) {
			test.log(LogStatus.SKIP, testCaseName + ": The  test Case is Skipped as Run Mode is N");
			throw new SkipException(testCaseName + ": The  test Case is Skipped as Run Mode is N");
		}

		test.log(LogStatus.INFO, "Staring the test");
		OpenBrowser(Prop.getProperty("browser"));
		Navigate("appurl");
		userlogin(data.get("UserName"), data.get("Password"));
		if(checkiflogin().equals(data.get("ExpectedResult")))
			ReportPass("User is able to Login Successfully");
		else {
			ReportFail("The actual And Expected didnt Match");
		}

		driver.close();
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
	public Object[][] getData(Method m) {
		init();
		xls = new Xls_Reader(System.getProperty("user.dir") + "\\Data.xlsx");
		return DataUtil.getTestData(xls, m.getName());

	}
}
