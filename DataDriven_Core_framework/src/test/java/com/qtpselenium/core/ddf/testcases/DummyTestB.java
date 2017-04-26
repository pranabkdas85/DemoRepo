package com.qtpselenium.core.ddf.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import ddfframework.Base.Base;
import ddfframework.Base.Xls_Reader;

public class DummyTestB extends Base {
	SoftAssert softassert = new SoftAssert();

	@Test(dataProvider = "getData")
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
		Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir") + "\\Data.xlsx");
		String sheetName = "Data";
		String testCaseName = "TestB";
		// reads data for only testCaseName

		int testStartRowNum = 1;
		while (!xls.getCellData(sheetName, 0, testStartRowNum).equals(testCaseName)) {
			testStartRowNum++;
		}
		System.out.println("Test starts from row - " + testStartRowNum);
		int colStartRowNum = testStartRowNum + 1;
		int dataStartRowNum = testStartRowNum + 2;

		// calculate rows of data
		int rows = 0;
		while (!xls.getCellData(sheetName, 0, dataStartRowNum + rows).equals("")) {
			rows++;
		}
		System.out.println("Total rows are  - " + rows);

		// calculate total cols
		int cols = 0;
		while (!xls.getCellData(sheetName, cols, colStartRowNum).equals("")) {
			cols++;
		}
		System.out.println("Total cols are  - " + cols);
		Object[][] data = new Object[rows][1];
		// read the data
		int dataRow = 0;
		Hashtable<String, String> table = null;
		for (int rNum = dataStartRowNum; rNum < dataStartRowNum + rows; rNum++) {
			table = new Hashtable<String, String>();
			for (int cNum = 0; cNum < cols; cNum++) {
				String key = xls.getCellData(sheetName, cNum, colStartRowNum);
				String value = xls.getCellData(sheetName, cNum, rNum);
				table.put(key, value);
				// 0,0 0,1 0,2
				// 1,0 1,1
			}
			data[dataRow][0] = table;
			dataRow++;
		}
		return data;
	}

}
