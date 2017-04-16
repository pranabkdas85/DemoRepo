import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Radio_buttons {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://paytm.com/");
		WebElement radio= driver.findElement(By.xpath("//*[@id='app']/div/div[3]/div/div[2]/div[1]/div[1]/div"));
		List<WebElement> LOV=radio.findElements(By.className("radioInfo"));
		System.out.println("The Size of the LOV is: " + LOV.size());
		LOV.get(0).click();
		for ( int i =0; i< LOV.size(); i++)
		{
			System.out.println("The " + i+ "th element is : " + LOV.get(i).getText());
			System.out.println(LOV.get(i).getAttribute("checked"));
		}
		for ( int j =0; j< LOV.size(); j++)
		{
			if (LOV.get(j).getAttribute("checked")=="true")
				System.out.println(LOV.get(j).getText() + "is checked");
		}

	}

}
