import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Rediff_2 {
static WebDriver driver =null;
	
	public static void main(String[] args) {
		//*[@id='popular_cat']/h3[1]/a
		//*[@id='popular_cat']/h3[2]/a
		//*[@id='popular_cat']/h3[3]/a
		//*[@id='popular_cat']/h3[4]/a
		
		System.setProperty("webdriver.gecko.driver","C:\\geckodriver_v14.exe");
		
		
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		FirefoxOptions options = new FirefoxOptions();
		options.setLogLevel(Level.SEVERE);
		capabilities.setCapability("moz:firefoxOptions", options);
		driver = new FirefoxDriver(capabilities);
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.get("http://shopping.rediff.com/?sc_cid=inhome_icon");
		driver.navigate().to("http://shopping.rediff.com/?sc_cid=inhome_icon");
		
		String part1="//*[@id='popular_cat']/h3[";
		String part2="]/a";
		/*
		 * for (int i=1;i<=14;i++)
		{
			String text=driver.findElement(By.xpath(part1+i+part2)).getText();
			System.out.println(text);
			driver.findElement(By.xpath(part1+i+part2)).click();
			System.out.println(driver.getTitle());
			//driver.get("http://shopping.rediff.com/?sc_cid=inhome_icon");
			driver.navigate().back();
			*/
		int i=0;
		while(IsElementPresent(part1+i+part2)){
			String text= driver.findElement(By.xpath(part1+i+part2)).getText();
			System.out.println(text);
			driver.findElement(By.xpath(part1+i+part2)).click();
			System.out.println(driver.getTitle());
			driver.navigate().back();
			i++;
			}
		}
	public static boolean IsElementPresent(String xpathexp)
	{
		List<WebElement> allelements=driver.findElements(By.xpath(xpathexp));
		if(allelements.size()==0)
			return  false;
		else
			return true;
	}		
	}

