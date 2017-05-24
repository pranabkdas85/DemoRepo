package Salesforce.com.ddf;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Hashtable;

import org.openqa.selenium.support.ui.Select;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.gargoylesoftware.htmlunit.javascript.host.Iterator;
import com.relevantcodes.extentreports.LogStatus;

public class Contacts extends base.Base {
	Xls_Reader xls;

	@Test(dataProvider = "getData")
	public void Contacts_dropdown(Hashtable<String, String> data) throws IOException {
		testCaseName = "Contacts_dropdown";
		test = rep.startTest("Contacts_dropdown");
		test.log(LogStatus.INFO, data.toString());

		if (!DataUtil.isRuunnable(testCaseName, xls) || data.get("Runmode").toUpperCase().equals("N")) {
			test.log(LogStatus.SKIP, testCaseName + ": The  test Case is Skipped as Run Mode is N");
			throw new SkipException(testCaseName + ": The  test Case is Skipped as Run Mode is N");
		}

		test.log(LogStatus.INFO, "Starting the Test");
		OpenBrowser("Chrome");
		Navigate("appurl");
		userlogin(Prop.getProperty("uderid"), Prop.getProperty("password"));
		// click on contact tab
		Click("contacts_xpath");
		String[] ActualLOV = getlovs("contactsdropdown_xpath");
		String[] expectedLOV = data.get("Contacts_LOV").split(",");

		if (!Arrays.equals(ActualLOV, expectedLOV)) {
			test.log(LogStatus.INFO, "The excepted List of values are :" + Arrays.deepToString(expectedLOV));
			ReportFail("There is a mismatch in the number of drop down in the contact");
		} else {
			ReportPass("The List of values matched for the contacts");
		}

		driver.close();
	}

	@Test(dataProvider = "getData")
	public void createcontacts(Hashtable<String, String> data) throws IOException {
		testCaseName = "createcontacts";
		test = rep.startTest("createcontacts");
		test.log(LogStatus.INFO, data.toString());

		if (!DataUtil.isRuunnable(testCaseName, xls) || data.get("Runmode").toUpperCase().equals("N")) {
			test.log(LogStatus.SKIP, testCaseName + ": The  test Case is Skipped as Run Mode is N");
			throw new SkipException(testCaseName + ": The  test Case is Skipped as Run Mode is N");
		}

		test.log(LogStatus.INFO, "Starting the Test");
		OpenBrowser("Chrome");
		Navigate("appurl");
		userlogin(Prop.getProperty("uderid"), Prop.getProperty("password"));
		Click("contacts_xpath");
		Click("contacts_newButton_xpath");
		String[] fnlov = getlovs("FirstNameLOV_id");
		String[] expectedfnlov = data.get("fnlov").split(",");
		test.log(LogStatus.INFO, ("The expected List of Values are :" + Arrays.toString(expectedfnlov)));
		if (!Arrays.equals(fnlov, expectedfnlov))
			ReportFail("There is a mismatch in the List of values under Contacts>>New Contacts>>Firstname ");
		else
			ReportPass("The List of values under Contacts>>New Contacts>>Firstname matched");
		Select s = new Select(getelement("FirstNameLOV_id"));
		s.selectByVisibleText("Mr.");
		Type("FirstName_id", "Pranab");
		Type("Middlename_id", "Kumar");
		Click("openAccount_xpath");
		popupselectaccount("accountpopup_xpath");
		Type("Lastname_xpath", "Das");
		Click("savebtn_xpath");

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
	public Object[][] getData(Method m) {
		init();
		xls = new Xls_Reader(System.getProperty("user.dir") + "\\Data.xlsx");
		return DataUtil.getTestData(xls, m.getName());

	}

}
