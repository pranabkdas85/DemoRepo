import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class list {
public static void main(String args[]){
	WebDriver driver= new FirefoxDriver();
	driver.manage().window().maximize();
	driver.get("http://www.bbc.com/");
	List<WebElement> alllinks=driver.findElements(By.tagName("a"));
	System.out.println(alllinks.size());
	for (int i =0;i<alllinks.size();i++){
		System.out.println((i+1)+ "thElement is " + alllinks.get(i).getText()+ alllinks.get(i).isDisplayed());
		}
	
	}
}

