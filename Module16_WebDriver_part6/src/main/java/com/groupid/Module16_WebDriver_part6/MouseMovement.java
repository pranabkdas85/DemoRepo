package com.groupid.Module16_WebDriver_part6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.internal.EventFiringMouse;

public class MouseMovement {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver web_driver = new ChromeDriver();
		EventFiringWebDriver driver = new EventFiringWebDriver(web_driver);
		MyListener myListener = new MyListener();
		driver.register(myListener);

		driver.get("https://www.flipkart.com/");
		EventFiringMouse mouse = new EventFiringMouse(driver, myListener);
		// move mouse
		Locatable hoverItem = (Locatable) driver
				.findElement(By.xpath("//*[@id='container']/div/footer/div/div[1]/div[1]/div[1]/div/a[1]"));
		Coordinates c = hoverItem.getCoordinates();
		try {
			mouse.mouseMove(c);
		} catch (Exception e1) {

		}
		// right click
		driver.findElement(By.xpath("//*[@id='container']/div/footer/div/div[1]/div[1]/div[1]/div/a[1]"))
				.sendKeys(Keys.chord(Keys.SHIFT, Keys.F10));
		// coordinates
		Point p = driver.findElement(By.xpath("//*[@id='container']/div/footer/div/div[1]/div[1]/div[1]/div/a[1]"))
				.getLocation();
		System.out.println(p.x);
		System.out.println(p.y);

	}

}
