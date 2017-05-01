package com.qtpselenium.core.ddf.testcases;

import java.lang.reflect.Method;
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
		if (!DataUtil.isRuunnable(testCaseName, xls) || data.get("Runmode").toUpperCase().equals("N")) {
			test.log(LogStatus.SKIP, testCaseName+": The  test Case is Skipped as Run Mode is N");
			throw new SkipException(testCaseName+": The  test Case is Skipped as Run Mode is N");
		}
		// Assert.fail();
		test.log(LogStatus.INFO, "Inside A1");
		ReportPass("DummyTestA:TestA1 Passed ");
	}

	@Test(priority = 2, dataProvider = "getData")
	public void TestA2(Hashtable<String, String> data) {
		testCaseName = "TestA2";
		test = rep.startTest("DummyTestA:TestA2");
		test.log(LogStatus.INFO, data.toString());
		if (!DataUtil.isRuunnable(testCaseName, xls) || data.get("Runmode").equals("N")) {
			test.log(LogStatus.SKIP, testCaseName+": The  test Case is Skipped as Run Mode is N");
			throw new SkipException(testCaseName+": The  test Case is Skipped as Run Mode is N");
		}
		test.log(LogStatus.INFO, "Inside A2");
		ReportPass("DummyTestA:TestA2 Passed ");
	}

	@Test(priority = 3, dataProvider = "getData")
	public void TestA3(Hashtable<String, String> data) {
		testCaseName = "TestA3";
		test = rep.startTest("DummyTestA:TestA3");
		if (!DataUtil.isRuunnable(testCaseName, xls) || data.get("Runmode").equals("N")) {
			test.log(LogStatus.SKIP, testCaseName+": The  test Case is Skipped as Run Mode is N");
			throw new SkipException(testCaseName+": The  test Case is Skipped as Run Mode is N");
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
	public Object[][] getData(Method m) {
		init();
		xls = new Xls_Reader(System.getProperty("user.dir") + "\\Data.xlsx");
		return DataUtil.getTestData(xls, m.getName());

	}
}
