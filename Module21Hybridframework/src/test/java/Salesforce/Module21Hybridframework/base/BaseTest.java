package Salesforce.Module21Hybridframework.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Salesforce.Module21Hybridframework.Keywords;
import Salesforce.Module21Hybridframework.util.DataUtil;
import Salesforce.Module21Hybridframework.util.ExtentManager;
import Salesforce.Module21Hybridframework.util.Xls_Reader;

public class BaseTest {
	public ExtentReports rep = ExtentManager.getInstance();
	public ExtentTest test;
	public Keywords app;
	public Xls_Reader xls ;
	public String testName;
	
	@AfterMethod
	public void quit(){
		if(rep!=null){
			rep.endTest(test);
			rep.flush();
		}
		// quit 
		if(app!=null)
			app.getGenericKeyWords().closeBrowser();
	}
	
	@DataProvider
	public Object[][] getData(){
		return DataUtil.getData(xls, testName);
	}
}
