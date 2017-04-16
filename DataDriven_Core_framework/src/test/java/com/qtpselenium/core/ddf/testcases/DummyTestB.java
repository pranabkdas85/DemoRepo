package com.qtpselenium.core.ddf.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import ddfframework.Base.Base;

public class DummyTestB extends Base {
	SoftAssert softassert = new SoftAssert();

	@Test
	public void TestB() throws IOException {
		test = rep.startTest("DummyTestB");
		test.log(LogStatus.INFO, "Starting the Test : DummyTestB");
		OpenBrowser("Chrome");
		test.log(LogStatus.INFO, "Starting the Browser");
		Navigate("aapurl");

		// verify the text
		if (VerifyText("signintext_xpath", "SigninText"))
			test.log(LogStatus.PASS, "The header text is ok");
		else {
			ReportFail("There is a mismatch in the header text");
		}
		/*softassert.assertTrue(false, "Error Message 1");
		softassert.assertTrue(false, "Error Message 2");
		softassert.assertTrue(true, "Error Message 3");
		softassert.assertTrue(false, "Error Message 4");*/

		// check if email field is present
		// if the email id field is not present, it will report failure
		if (!Iselementpresent("Email_xpath"))
			ReportFail("the email id is not there");
		else
			System.out.println("the Header is Pass");

		Type("Email_xpath", "pranabdas");
		Click("NextButon_xpath");
		VerifyTile();

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
}
