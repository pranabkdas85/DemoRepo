import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Rediff {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		System.setProperty("webdriver.ie.driver","C:\\IEDriverServer.exe");
		WebDriver driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
		
		Set<String> windowids=driver.getWindowHandles();
		System.out.println("Before going to Rediff :" + windowids.size());
		Iterator<String> it= windowids.iterator();
		System.out.println( it.next());
		
		System.out.println("---------------------");
		driver.get("http://www.rediff.com/");
		
		windowids=driver.getWindowHandles();
		System.out.println(" After going to Rediff : " + windowids.size());
		it= windowids.iterator();
		while(it.hasNext())
			{
			System.out.println(it.next());
			}
		
		// how  to close the pop up?
		it= windowids.iterator();
		String mainwindow=it.next();
		String popupwindow;
		while(it.hasNext())
		{
			popupwindow=it.next();
			driver.switchTo().window(popupwindow);
			driver.close();
		
		}
		driver.switchTo().window(mainwindow);
		windowids=driver.getWindowHandles();
		System.out.println(" After closing all pop ups : " + windowids.size());
	}

}
