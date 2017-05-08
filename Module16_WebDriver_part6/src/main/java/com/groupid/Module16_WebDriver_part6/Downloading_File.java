package com.groupid.Module16_WebDriver_part6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Downloading_File {
	public static void main(String[] args) {
		FirefoxProfile profile = new FirefoxProfile();

		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		profile.setPreference("browser.download.dir", "D:\\test");
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
				"application/msword,application/x-rar-compressed,application/octet-stream,application/csv,text/csv");
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver(profile);
		driver.get("http://qtpselenium.com/test/testdownload.php");
		driver.findElement(By.xpath("html/body/a[1]")).click();
		driver.findElement(By.xpath("html/body/a[2]")).click();
		driver.findElement(By.xpath("html/body/a[3]")).click();

	}

}
