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

public class DummyTestC extends Base {
	Xls_Reader xls;

	@Test(dataProvider = "getData")
	public void TestC(Hashtable<String, String> data) throws IOException {
		test = rep.startTest("DummyTestC");
		// System.out.println("das");
		test.log(LogStatus.INFO, data.toString());

		if (data.get("Runmode").equals("N")) {
			test.log(LogStatus.SKIP, "The  test Case is Skipped as Run Mode is N");
			throw new SkipException("The  test Case is Skipped as Run Mode is N");
		}
		test.log(LogStatus.INFO, "Inside C");
		test.log(LogStatus.FAIL, "Failed");
		// TakeScreenShot();
		test.log(LogStatus.INFO, "ScreenShot-->>" + test.addScreenCapture("D:\\test.jpg"));
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
