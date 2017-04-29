package com.qtpselenium.core.ddf.testcases;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.Assert;
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

	@Test(dataProvider = "getData", priority = 1)
	public void TestA1(Hashtable<String, String> data) {
		test = rep.startTest("DummyTestA:TestA1");
		test.log(LogStatus.INFO, data.toString());
		// Assert.fail();
		test.log(LogStatus.INFO, "Inside A1");
		ReportPass("DummyTestA Passed ");
	}

	@Test(priority = 2, dataProvider = "getDataA2", dependsOnMethods = { "TestA1" })
	public void TestA2(Hashtable<String, String> data) {
		test = rep.startTest("DummyTestA:TestA2");
		test.log(LogStatus.INFO, "Inside A2");
	}

	@Test(priority = 3, dataProvider = "getDataA2", dependsOnMethods = { "TestA2" })
	public void TestA3(Hashtable<String, String> data) {
		test = rep.startTest("DummyTestA:TestA3");
		test.log(LogStatus.INFO, "Inside A3");
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
		return DataUtil.getTestData(xls, "TestA1");
	}

	@DataProvider
	public Object[][] getDataA2() {
		init();

		Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir") + "\\Data.xlsx");
		return DataUtil.getTestData(xls, "TestA2");

	}
}
