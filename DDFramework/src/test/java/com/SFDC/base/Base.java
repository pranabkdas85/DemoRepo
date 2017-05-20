package com.SFDC.base;

import java.io.FileInputStream;
import java.sql.Driver;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.internal.PropertiesFile;

public class Base {
	public static WebDriver driver = null;
	public static Properties porp;

	public static void initial() {
		if (porp == null) {
			porp = new Properties();
			try {

				FileInputStream fs = new FileInputStream(
						System.getProperty("user.dir") + ("\\src\\resource\\configProperties.properties"));
				porp.load(fs);
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}
	}

	public static void Open_browser(String browser) {

		if (browser.equals("Chrome")) {
			System.setProperty("WebDriver.chrome.driver", "C:\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		if (browser.equals("Firefox")) {
			System.setProperty("WebDriver.greko.driver", "C:\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		if (browser.equals("IE")) {
			System.setProperty("WebDriver.ie.driver", "C:\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
	}

	public static WebElement getelement(String locator_key) {

		WebElement e = null;

		if (locator_key.endsWith("_xpath")) {
			e = driver.findElement(By.xpath(locator_key));
		} else if (locator_key.endsWith("_id")) {
			e = driver.findElement(By.id(locator_key));
		} else if (locator_key.endsWith("_class")) {
			e = driver.findElement(By.className(locator_key));
		}
		return e;
	}

	public static void Click(String locator_key) {
		getelement(locator_key).click();
	}

	public static void Type(String locator_key, String text) {
		getelement(locator_key).sendKeys(text);
	}

	// ***************validations******************

	public static Boolean verifytitle(String page_title) {
		String actualTitle = driver.getTitle();
		String expectedtitle = porp.getProperty(page_title);
		if (actualTitle.equals(expectedtitle))
			return true;
		else
			return false;
	}

	public static Boolean verififyText(String Text, String locator_key) {
		String Actualtest = getelement(locator_key).getText();
		String expectedtext = porp.getProperty(Text);
		if (Actualtest.equals(expectedtext))
			return true;
		else
			return false;
	}

	public static boolean iselementpresent(String locator_key) {
		List<WebElement> e = null;
		if (locator_key.endsWith("_xpath")) {
			e = driver.findElements(By.xpath(locator_key));
		} else if (locator_key.endsWith("_id"))
			e = driver.findElements(By.id(locator_key));
		else if (locator_key.endsWith("_class"))
			e = driver.findElements(By.className(locator_key));
		if (e.size() == 0)
			return false;
		else
			return true;

	}
}
