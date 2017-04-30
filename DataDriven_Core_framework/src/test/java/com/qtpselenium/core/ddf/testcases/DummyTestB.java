package com.qtpselenium.core.ddf.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qtpselenium.DataUtil;
import com.qtpselenium.Xls_Reader;
import com.relevantcodes.extentreports.LogStatus;

import ddfframework.Base.Base;

public class DummyTestB extends Base {
	Xls_Reader xls;

	@BeforeMethod
	public void initial() {
		softassert = new SoftAssert();
	}

	@Test(dataProvider = "getData")
	public void TestB(Hashtable<String, String> data) throws IOException {
		testCaseName = "TestB";
		test = rep.startTest("DummyTestB");
		test.log(LogStatus.INFO, "Starting the Test : DummyTestB");
		test.log(LogStatus.INFO, data.toString());

		if (!DataUtil.isRuunnable(testCaseName, xls) || data.get("Runmode").equals("N")) {
			test.log(LogStatus.SKIP, "The  test Case is Skipped as Run Mode is N");
			throw new SkipException("The  test Case is Skipped as Run Mode is N");
		}

		OpenBrowser("Mozilla");
		test.log(LogStatus.INFO, "Starting the Browser");
		Navigate("aapurl");

		// verify the text
		if (VerifyText("signintext_xpath", "SigninText"))
			test.log(LogStatus.PASS, "The header text is ok");
		else {
			ReportFail("There is a mismatch in the header text");
		}

		softassert.assertTrue(VerifyText("signintext_xpath", "SigninText"), "There is a mismatch in the header text");

		softassert.assertTrue(false, "Error Message 2");
		softassert.assertTrue(true, "Error Message 3");
		softassert.assertTrue(false, "Error Message 4");

		// validate if email field is present
		if (!Iselementpresent("Email_xpath"))
			ReportFail("the email id is not there");
		else
			ReportPass("The email id is there ");

		Type("Email_xpath", "pranabdas");

		Click("NextButon_xpath");
		if (VerifyTile("Sign in - Google Accounts"))
			ReportPass("The Login Page title is correct");
		else
			ReportFail("The Login Page title is not correct");
		test.log(LogStatus.PASS, "DummyTestB is passed");
		// TakeScreenShot();
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
		xls = new Xls_Reader(System.getProperty("user.dir") + "\\Data.xlsx");
		return DataUtil.getTestData(xls, "TestB");
	}

}
