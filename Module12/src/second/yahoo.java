package second;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class yahoo {
public static void main (String args[]) throws InterruptedException{
	WebDriver driver= new FirefoxDriver();
	driver.get("https://in.yahoo.com/?p=us");
	driver.findElement(By.id("UHSearchBox")).sendKeys("Loadrunn");
	Thread.sleep(5000);
	//driver.findElement(By.xpath("*[@id='yui_3_12_0_3_1489331247352_1798']/a")).click();
	//String text = 
	driver.findElement(By.cssSelector("*[id^='yui_3_12_0_3_'] a")).click();                     
	//System.out.println(text);
}
}
