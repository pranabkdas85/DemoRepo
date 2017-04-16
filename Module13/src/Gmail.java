import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Gmail {

	public static void main(String[] args) {
		// type, clear, read
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://gmail.com" );
		driver.findElement(By.id("Email")).sendKeys("xxxxx");
		//String text=driver.findElement(By.id("Email")).getText();
		String text=driver.findElement(By.id("Email")).getAttribute("value");
		System.out.println("test is " +text);
		driver.findElement(By.id("Email")).clear(); 
		text= driver.findElement(By.xpath("//div[@class='banner']/h1")).getText();
		System.out.println(text );
	}
}
