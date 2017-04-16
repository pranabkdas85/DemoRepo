package ddfframework.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import com.qtpselenium.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.jna.platform.FileUtils;

public class Base {

	public WebDriver driver = null;
	public Properties Prop;

	public ExtentReports rep = ExtentManager.getInstance();
	public ExtentTest test;

	public void OpenBrowser(String Browser) throws IOException {

		if (Prop == null) {
			Prop = new Properties();
			try {
				FileInputStream fs = new FileInputStream(
						"C:\\Users\\Admin\\workspace\\DataDriven_Core_framework\\src\\test\\resources\\ProjectConfig.Properties");
				Prop.load(fs);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		System.setProperty("webdriver.gecko.driver",
				Prop.getProperty("firefoxdriver_exe"));
		System.setProperty("webdriver.chrome.driver",
				Prop.getProperty("chromedriver_exe"));
		System.setProperty("webdriver.ie.driver",
				Prop.getProperty("iedriver_exe"));

		if (Browser.equals("Morzilla")) {

			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			FirefoxOptions options = new FirefoxOptions();
			options.setLogLevel(Level.SEVERE);
			capabilities.setCapability("moz:firefoxOptions", options);
			driver = new FirefoxDriver(capabilities);

		} else if (Browser.equals("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("credentials_enable_service", false);
			options.setExperimentalOption("prefs", chromePrefs);
			options.addArguments("disable-infobars");
			driver = new ChromeDriver(options);
		}
		if (Browser.equals("Internet Explorer")) {
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	// Responsible to find element in the Page
	public WebElement getelement(String locator_Key) {
		WebElement we = null;
		try {
			if (locator_Key.endsWith("_id"))
				we = driver.findElement(By.id(Prop.getProperty(locator_Key)));
			else if (locator_Key.endsWith("_xpath"))
				we = driver
						.findElement(By.xpath(Prop.getProperty(locator_Key)));
			else if (locator_Key.endsWith("_name"))
				we = driver
						.findElement(By.name(Prop.getProperty("locator_Key")));
			else {
				/* ReportFail("Locator is incorrect" + locator_Key); */
				Assert.fail("Locator is incorrect" + locator_Key);
			}
		} catch (Exception e) {
			/* ReportFail(e.getMessage()); */
			e.printStackTrace();
			Assert.fail("Failed Test Case" + e.getMessage());
		}
		return we;
	}

	public void Navigate(String appurl) {
		driver.get(Prop.getProperty("appurl"));
	}

	public void Click(String locator_Key) {
		getelement(locator_Key).click();

		// driver.findElement(By.xpath(Prop.getProperty("NextButon_xpath"))).click();

	}

	public void Type(String locator_Key, String data) {
		getelement(locator_Key).sendKeys(data);

	}

	// *******************Validation Functions**********
	public Boolean VerifyTile() {
		return false;
	}

	public Boolean Iselementpresent(String locator_Key) {
		List<WebElement> e = null;
		if (locator_Key.endsWith("_id"))
			e = driver.findElements(By.id(Prop.getProperty(locator_Key)));
		else if (locator_Key.endsWith("_xpath"))
			e = driver.findElements(By.xpath(Prop.getProperty(locator_Key)));
		else if (locator_Key.endsWith("_name"))
			e = driver.findElements(By.name(Prop.getProperty("locator_Key")));
		else {
			ReportFail("Locator is incorrect" + locator_Key);
			Assert.fail("Locator is incorrect" + locator_Key);
		}
		if (e.size() == 0)
			return false;
		else
			return true;

	}

	public Boolean VerifyText(String locator_key, String expectedtextkey) {
		String actual_text = getelement(locator_key).getText().trim();
		String expected_text = Prop.getProperty(expectedtextkey);

		if (actual_text.equals(expected_text))
			return true;
		else
			return false;

	}

	// ****************Reporting Functions************

	public void ReportPass(String msg) {
		test.log(LogStatus.PASS, msg);
	}

	public void ReportFail(String msg) {
		test.log(LogStatus.FAIL, msg);
		TakeScreenShot();
		Assert.fail(msg);
	}

	public void TakeScreenShot() {

		Date d = new Date();
		String screenshotFile = d.toString().replace(":", "_")
				.replace(" ", "_")
				+ ".jpg";
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);

		try {

			org.apache.commons.io.FileUtils.copyFile(scrFile,
					new File(System.getProperty("user.dir")
							+ "//Screen_Shots//" + screenshotFile));

		} catch (IOException e) {
			e.printStackTrace();
		}

		test.log(
				LogStatus.INFO,
				"ScreenShot->"
						+ test.addScreenCapture(System.getProperty("user.dir")
								+ "//Screen_Shots//" + screenshotFile));

	}

}
