import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Dropdown {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("http://qtpselenium.com/home/contact_trainer");
		WebElement country=driver.findElement(By.name("country_id"));
		country.sendKeys("Egypt");
		List<WebElement> list = country.findElements(By.tagName("option"));
		System.out.println("total number of countries :" + list.size());
		for (int i =0 ; i<list.size(); i++)
		{ 
			System.out.println("Country" + i + list.get(i).getText()+ list.get(i).getAttribute("selected"));
		}
	}

}
