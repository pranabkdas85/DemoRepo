package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Salesforce.com.ddf.Constants;
import Salesforce.com.ddf.ExtentManager;

public class Base {

	public WebDriver driver = null;
	public Properties Prop;
	public SoftAssert softassert;
	public String testCaseName;
	public ExtentReports rep = ExtentManager.getInstance();
	public ExtentTest test;
	public JavascriptExecutor js;

	public void init() {

		if (Prop == null) {
			Prop = new Properties();
			try {
				// FileInputStream fs = new
				// FileInputStream(System.getProperty("user.dir") +
				// ("\\src\\test\\resources\\ProjectConfig.Properties"));
				InputStream fs = new FileInputStream(Constants.propertiesFilePath);
				Prop.load(fs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// ******************generic Functions******************************
	public void OpenBrowser(String Browser) throws IOException {
		DesiredCapabilities capabilities = null;
		if (Browser.equals("Mozilla")) {
			System.setProperty("webdriver.gecko.driver", getDriverPath(Browser));
			capabilities = DesiredCapabilities.firefox();
			FirefoxOptions options = new FirefoxOptions();
			options.setLogLevel(Level.SEVERE);
			capabilities.setCapability("moz:firefoxOptions", options);
			driver = new FirefoxDriver(capabilities);
		} else if (Browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", getDriverPath(Browser));
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("credentials_enable_service", false);
			options.setExperimentalOption("prefs", chromePrefs);
			options.addArguments("disable-infobars");
			driver = new ChromeDriver(options);
		} else if (Browser.equals("IE")) {
			System.setProperty("webdriver.ie.driver", getDriverPath(Browser));
			capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver = new InternetExplorerDriver(capabilities);
		} else {
			ReportFail("Invalid Browser name provided.");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	// Responsible to find element in the Page
	public WebElement getelement(String locator_Key) {
		test.log(LogStatus.INFO, "Inside the getelement function and searching for " + locator_Key);
		WebElement we = null;
		try {
			if (locator_Key.endsWith("_id"))
				we = driver.findElement(By.id(Prop.getProperty(locator_Key)));
			else if (locator_Key.endsWith("_xpath"))
				we = driver.findElement(By.xpath(Prop.getProperty(locator_Key)));
			else if (locator_Key.endsWith("_name"))
				we = driver.findElement(By.name(Prop.getProperty(locator_Key)));
			else {
				ReportFail("Locator is incorrect" + locator_Key);
				Assert.fail("Locator is incorrect" + locator_Key);
			}
		} catch (Exception e) {
			/* ReportFail(e.getMessage()); */
			e.printStackTrace();
			ReportFail(e.getMessage());
		}
		return we;
	}

	public void Navigate(String appurl) {
		test.log(LogStatus.INFO, " Oppening the url :" + appurl);
		driver.get(Prop.getProperty("appurl"));
	}

	public void Click(String locator_Key) {
		test.log(LogStatus.INFO, "clicking on" + locator_Key);
		getelement(locator_Key).click();
	}

	public void Type(String locator_Key, String data) {
		getelement(locator_Key).sendKeys(data);
		test.log(LogStatus.INFO, "Typed: " + data + "onto the field :" + locator_Key);
	}

	public void selectlov(String locator_key, int index) {
		WebElement we = getelement(locator_key);
		Select s = new Select(we);
		s.selectByIndex(index);
	}

	public String[] getlovs(String locator_key) {
		test.log(LogStatus.INFO, "Inside the getlov function to get the list of values");
		ArrayList<String> arl = new ArrayList<String>();
		Select s = new Select(getelement(locator_key));
		List<WebElement> we = s.getOptions();
		for (int i = 0; i < we.size(); i++) {
			arl.add(we.get(i).getText());
		}
		String[] str = new String[arl.size()];
		arl.toArray(str);
		test.log(LogStatus.INFO, "The Actual List of values are :" + Arrays.toString(str));
		return str;
	}

	public void waituntilpagecomplete() {
		long intialTime = System.currentTimeMillis();
		long currentTime = intialTime;
		//Max Wait time is given for 5 minutes ie, 300000 ms
		long maxWaitTime = 5*60*1000;
		js = ((JavascriptExecutor) driver);
		
		while (!(js.executeScript("return document.readyState").equals("complete")) && currentTime-intialTime<maxWaitTime) {
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			currentTime = System.currentTimeMillis();
		}

	}

	public void closepopupwindows() {
		java.util.Set<String> windowids = driver.getWindowHandles();
		Iterator<String> it = windowids.iterator();
		String Mainwindow = it.next();
		while (it.hasNext()) {
			String popup_window = it.next();
			driver.switchTo().window(popup_window);
			driver.close();
			test.log(LogStatus.INFO, "closed the pop up window");
		}
		driver.switchTo().window(Mainwindow);
	}

	public void selectdate(String date) throws ParseException, InterruptedException {
		SimpleDateFormat sdf = new SimpleDateFormat("d/MM/yyyy");
		Date datetobeselected = sdf.parse(date);
		String d = new SimpleDateFormat("d").format(datetobeselected);
		String month = new SimpleDateFormat("MM").format(datetobeselected);
		int monthint = Integer.parseInt(month);
		String year = new SimpleDateFormat("yyyy").format(datetobeselected);
		Select s = new Select(getelement("yeardropdown_xpath"));
		s.selectByValue(year);
		s = new Select(getelement("monthdropdown_xpath"));
		Thread.sleep(6000);
		getlovs("monthdropdown_xpath");
		s.selectByIndex(monthint - 1);
		driver.findElement(By.xpath("//div[@id='datePicker']//table[@id='datePickerCalendar']//td[text()='" + d + "']"))
				.click();
	}

	public String generaterandomname(int n) {
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		String output = sb.toString();
		test.log(LogStatus.INFO, " The Random Number generated is : " + output);
		return output;
	}

	// **********APP Functions*********************
	public void userlogin(String userid, String password) {
		test.log(LogStatus.INFO, "login by id: " + userid + " and password: " + password);
		Type("Loginid_xpath", userid);
		Type("password_xpath", password);
		Click("Loginbutton_xpath");
	}

	public void popupselectaccount(String locator_key) {
		java.util.Set<String> windowsid = driver.getWindowHandles();
		java.util.Iterator<String> it = windowsid.iterator();
		String Mainwindows = it.next();
		String popup_window = null;
		while (it.hasNext()) {
			popup_window = it.next();
			driver.switchTo().window(popup_window);
			test.log(LogStatus.INFO, "Window switched");
			driver.switchTo().frame(1);
			Click(locator_key);
		}
		driver.switchTo().window(Mainwindows);
	}

	// *******************Validation Functions**********
	public Boolean VerifyTitle(String Login_title) {
		test.log(LogStatus.INFO, "Verifying the tile of the page:");
		String Actual_Title = driver.getTitle();
		String Expected_title = Prop.getProperty("Login_title");
		if (Actual_Title.equals(Expected_title))
			return true;
		else
			return false;
	}

	public Boolean Iselementpresent(String locator_Key) {
		List<WebElement> e = null;
		if (locator_Key.endsWith("_id"))
			e = driver.findElements(By.id(Prop.getProperty(locator_Key)));
		else if (locator_Key.endsWith("_xpath"))
			e = driver.findElements(By.xpath(Prop.getProperty(locator_Key)));
		else if (locator_Key.endsWith("_name"))
			e = driver.findElements(By.name(Prop.getProperty(locator_Key)));
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
		String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "//Screen_Shots//" + screenshotFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.log(LogStatus.INFO, "ScreenShot->"
				+ test.addScreenCapture(System.getProperty("user.dir") + "//Screen_Shots//" + screenshotFile));
	}

	public String getDriverPath(String browser) {
		String driverPath = null;
		String pathFromEnv = null;

		switch (browser) {
		case "Mozilla":
			pathFromEnv = System.getenv("GECKODRIVER_HOME");
			driverPath = null == pathFromEnv ? Prop.getProperty(browser) : pathFromEnv;
			break;
		case "Chrome":
			pathFromEnv = System.getenv("CHROMEDRIVER_HOME");
			driverPath = null == pathFromEnv ? Prop.getProperty(browser) : pathFromEnv;
			break;
		case "IE":
			pathFromEnv = System.getenv("IEDRIVERSERVER_HOME");
			driverPath = null == pathFromEnv ? Prop.getProperty(browser) : pathFromEnv;
			break;
		}
		return driverPath;
	}
}
