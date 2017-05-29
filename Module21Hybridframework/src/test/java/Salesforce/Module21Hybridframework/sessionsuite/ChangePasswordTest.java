package Salesforce.Module21Hybridframework.sessionsuite;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Salesforce.Module21Hybridframework.Keywords;
import Salesforce.Module21Hybridframework.base.BaseTest;
import Salesforce.Module21Hybridframework.util.Constants;
import Salesforce.Module21Hybridframework.util.DataUtil;
import Salesforce.Module21Hybridframework.util.Xls_Reader;

public class ChangePasswordTest extends BaseTest{
	
	
	
	@BeforeTest
	public void init(){
		xls = new Xls_Reader(Constants.SessionSuite_XLS);
		testName = "ChangePasswordTest";
	}
	
	@Test(dataProvider="getData")
	public void changePasswordTest(Hashtable<String,String> data){
		test = rep.startTest(testName);
		test.log(LogStatus.INFO, data.toString());
		
		if(DataUtil.isSkip(xls, testName) || data.get("Runmode").equals("N")){
			test.log(LogStatus.SKIP, "Skipping the test as runmode is N");
			throw new SkipException("Skipping the test as runmode is N");
		}
		
		test.log(LogStatus.INFO, "Starting "+testName);
		
		app = new Keywords(test);
		test.log(LogStatus.INFO, "Executing keywords");
		app.executeKeywords(testName, xls,data);
		// add the screenshot
		//app.getGenericKeyWords().reportFailure("xxxx");
		test.log(LogStatus.PASS, "PASS");
		app.getGenericKeyWords().takeScreenShot();
	}
		
}
