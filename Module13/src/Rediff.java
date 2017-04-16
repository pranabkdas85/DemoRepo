import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Rediff {
public static void main(String args[]){
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://shopping.rediff.com/");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	WebElement box= driver.findElement(By.xpath("//div[@id='popular_cat']"));
	List<WebElement> links= box.findElements(By.tagName("a"));
	System.out.println(links.size());
	for (int i=0;i<links.size();i++)
	{
		System.out.println(links.get(i).getText());
		links.get(i).click();
		System.out.println(driver.getTitle());
		driver.get("http://shopping.rediff.com/");
		box= driver.findElement(By.xpath("//div[@id='popular_cat']"));
		links= box.findElements(By.tagName("a"));
		 
	}
	 
}
}
