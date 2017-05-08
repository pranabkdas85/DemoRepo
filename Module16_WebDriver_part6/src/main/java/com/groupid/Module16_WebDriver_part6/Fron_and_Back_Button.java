package com.groupid.Module16_WebDriver_part6;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Fron_and_Back_Button {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();
		driver.navigate().to("https://in.yahoo.com/?p=us");
		driver.findElement(By.xpath(".//*[@id='mega-topbar']/ul/li[2]/a")).click();
		Thread.sleep(5000L);
		// back button
		driver.navigate().back();
		Thread.sleep(5000L);
		driver.navigate().forward();
		Thread.sleep(5000L);

		driver.quit();

	}

}
