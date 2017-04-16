import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BBC {
public static void main(String args[])
{
	System.setProperty("webdriver.gecko.driver","C:\\geckodriver_v14.exe");
	WebDriver driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("http://bbc.com");
		          
	//driver.findElement(By.xpath("//*[@id='orb-nav-links']/ul/li[1]/a")).click();
	//driver.findElement(By.linkText("News")).click();
	//driver.findElement(By.partialLinkText("New")).click();
	//String text=driver.findElement(By.linkText("News")).getAttribute("href");
	//System.out.println(text);
	//driver.findElement(By.xpath("//li[@class='orb-nav-newsdotcom orb-w']/a")).click();
	//driver.findElement(By.cssSelector("[id='orb-nav-links'] a")).click();
	//driver.findElement(By.cssSelector("[id='orb-nav-links'] ul li:nth-child(3) a")).click();
	driver.findElement(By.cssSelector("div[id='orb-nav-links'] ul li:nth-child(3) a")).click();
	
}
}
