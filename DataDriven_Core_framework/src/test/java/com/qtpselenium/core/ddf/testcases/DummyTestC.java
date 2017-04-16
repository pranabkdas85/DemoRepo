package com.qtpselenium.core.ddf.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import ddfframework.Base.Base;

public class DummyTestC extends Base{
	
	@Test
	public void TestC(){
		test=rep.startTest("DummyTestC");
	System.out.println("das");
	test.log(LogStatus.INFO,"Inside C");
		
	test.log(LogStatus.FAIL,"Failed");
	
	TakeScreenShot();
	
	test.log(LogStatus.INFO,"ScreenShot-->>"+test.addScreenCapture("D:\\test.jpg"));
	}
	@AfterMethod
	public void quit(){
		rep.endTest(test);
		rep.flush();
	}
}
