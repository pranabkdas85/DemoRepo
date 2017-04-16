import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;


public class MakemyTrip {
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		FirefoxOptions options = new FirefoxOptions();
		options.setLogLevel(Level.SEVERE);
		capabilities.setCapability("moz:firefoxOptions", options);
		 WebDriver driver = new FirefoxDriver(capabilities);
		 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);// default time for driver.findelement
		//driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		
		driver.findElement(By.id("hp-widget__sfrom")).sendKeys("Hyderabad (HYD)");
		driver.findElement(By.xpath("input//[@id='hp-widget__sTo']")).clear();
		
		
		// WebDriverWait ,  FluentWait: these are explecit wait
		
		//SEARCH PAGE - 40 seconds
		
	//	WebDriverWait wait = new WebDriverWait(driver, 40); this will explecitely wait for 40 secs
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='xxxxflL city_name']")));
		/* this is fluent wait
		FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver);
		fWait.withTimeout(5, TimeUnit.SECONDS);
		fWait.pollingEvery(1, TimeUnit.SECONDS);
		fWait.ignoring(NoSuchElementException.class);
		fWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='xxxxflL city_name']")));
		*/
}
}
