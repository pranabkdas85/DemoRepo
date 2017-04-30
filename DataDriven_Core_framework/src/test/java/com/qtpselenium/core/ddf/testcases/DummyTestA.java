package com.qtpselenium.core.ddf.testcases;

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

public class DummyTestA extends Base {
	Xls_Reader xls;

	@BeforeMethod
	public void initial() {
		softassert = new SoftAssert();
	}

	@Test(dataProvider = "getData", priority = 1)
	public void TestA1(Hashtable<String, String> data) {
		testCaseName = "TestA1";
		test = rep.startTest("DummyTestA:TestA1");
		test.log(LogStatus.INFO, data.toString());
		if (!DataUtil.isRuunnable(testCaseName, xls) || data.get("Runmode").equals("N")) {
			test.log(LogStatus.SKIP, "The  test Case is Skipped as Run Mode is N");
			throw new SkipException("The  test Case is Skipped as Run Mode is N");
		}
		// Assert.fail();
		test.log(LogStatus.INFO, "Inside A1");
		ReportPass("DummyTestA:TestA1 Passed ");
	}

	@Test(priority = 2, dataProvider = "getDataA2", dependsOnMethods = { "TestA1" })
	public void TestA2(Hashtable<String, String> data) {
		testCaseName = "TestA2";
		test = rep.startTest("DummyTestA:TestA2");
		test.log(LogStatus.INFO, data.toString());
		if (!DataUtil.isRuunnable(testCaseName, xls) || data.get("Runmode").equals("N")) {
			test.log(LogStatus.SKIP, "The  test Case is Skipped as Run Mode is N");
			throw new SkipException("The  test Case is Skipped as Run Mode is N");
		}
		test.log(LogStatus.INFO, "Inside A2");
		ReportPass("DummyTestA:TestA2 Passed ");
	}

	@Test(priority = 3, dataProvider = "getDataA3", dependsOnMethods = { "TestA2" })
	public void TestA3(Hashtable<String, String> data) {
		testCaseName = "TestA3";
		test = rep.startTest("DummyTestA:TestA3");
		if (!DataUtil.isRuunnable(testCaseName, xls) || data.get("Runmode").equals("N")) {
			test.log(LogStatus.SKIP, "The  test Case is Skipped as Run Mode is N");
			throw new SkipException("The  test Case is Skipped as Run Mode is N");
		}
		test.log(LogStatus.INFO, data.toString());
		test.log(LogStatus.INFO, "Inside A3");
		ReportPass("DummyTestA:TestA3 Passed ");
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
		return DataUtil.getTestData(xls, "TestA1");
	}

	@DataProvider
	public Object[][] getDataA2() {
		init();
		xls = new Xls_Reader(System.getProperty("user.dir") + "\\Data.xlsx");
		return DataUtil.getTestData(xls, "TestA2");

	}

	@DataProvider
	public Object[][] getDataA3() {
		init();
		xls = new Xls_Reader(System.getProperty("user.dir") + "\\Data.xlsx");
		return DataUtil.getTestData(xls, "TestA3");

	}
}
