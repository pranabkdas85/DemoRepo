package com.groupid.Module16_WebDriver_part6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class ListenerTest {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");

		WebDriver web_driver = new FirefoxDriver();
		EventFiringWebDriver driver = new EventFiringWebDriver(web_driver);
		MyListener myListener = new MyListener();
		driver.register(myListener);

		driver.navigate().to("https://www.makemytrip.com/flights");
		driver.findElement(By.xpath("//*[@id='header_tab_hotels']/a")).click();

		Thread.sleep(5000L);
		// back button
		System.out.println("Going to click back button");
		driver.navigate().back();
		System.out.println("Clicking back button");
		Thread.sleep(5000);
		driver.navigate().forward();
		Thread.sleep(5000);  

		driver.quit();
	}

}
