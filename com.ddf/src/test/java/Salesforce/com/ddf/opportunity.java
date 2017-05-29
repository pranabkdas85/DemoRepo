package Salesforce.com.ddf;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import base.Base;

public class opportunity extends Base {

	Xls_Reader xls;

	@BeforeMethod
	public void initial() {
		softassert = new SoftAssert();
	}

	@Test(dataProvider = "getData", priority = 1)
	public void createopportunity(Hashtable<String, String> data)
			throws IOException, ParseException, InterruptedException {
		testCaseName = "createopportunity";
		test = rep.startTest("createopportunity");
		test.log(LogStatus.INFO, data.toString());
		if (!DataUtil.isRuunnable(testCaseName, xls) || data.get("Runmode").toUpperCase().equals("N")) {
			test.log(LogStatus.SKIP, testCaseName + ": The  test Case is Skipped as Run Mode is N");
			throw new SkipException(testCaseName + ": The  test Case is Skipped as Run Mode is N");
		}

		test.log(LogStatus.INFO, "Staring the test");
		OpenBrowser(Prop.getProperty("browser"));
		Navigate("appurl");
		userlogin(Prop.getProperty("uderid"), Prop.getProperty("password"));
		Click("opportinitytab_xpath");
		Click("newopportunitybutton_xpath");
		Click("closedate_xpath");
		selectdate(data.get("Closedate"));
		Type("oppname_xpath", data.get("oppname"));
		Click("oppopenAccount_xpath");
		popupselectaccount("accountpopup_xpath");
		selectlov("stage_xpath", 2);
		Type("description_xpath", generaterandomname(7));
		selectlov("Leadsource_xpath", 2);
		Click("savebtn_xpath");
		driver.close();
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
