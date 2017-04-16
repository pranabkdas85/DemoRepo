package com.qtpselenium.core.ddf.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import ddfframework.Base.Base;

public class DummyTestA extends Base {

	@Test(priority = 1)
	public void TestA1() {

		/*
		 * test=rep.startTest("DummyTestA"); Assert.fail();
		 */
		test.log(LogStatus.INFO, "Inside A1");

	}

	@Test(priority = 2, dependsOnMethods = { "TestA1" })
	public void TestA2() {
		/* test.log(LogStatus.INFO,"Inside A2"); */

	}

	@Test(priority = 3, dependsOnMethods = { "TestA2" })
	public void TestA3() {
		/* test.log(LogStatus.INFO,"Inside A1"); */
	}

	@AfterMethod
	public void quit() {
		/*
		 * rep.endTest(test); rep.flush();
		 */

	}
}
