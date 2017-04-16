import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class GoogleAutoSuggest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		System.setProperty("webdriver.ie.driver","C:\\IEDriverServer.exe");
		
		
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
	
	driver.get("https://www.google.co.in");
	driver.findElement(By.xpath("//*[@id='gs_htif0']")).sendKeys("cloths");
/*	JavascriptExecutor js = (JavascriptExecutor) driver;
	String script = js.getElementByClassName("tt-hint")[1].removeAttribute("disabled");
	js.executeScript("arguments[0].removeAttribute('disabled')",inp);*/
	}

}
