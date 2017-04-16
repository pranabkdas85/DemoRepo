import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Paytm {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.get("https://paytm.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[3]/div[3]/div")).click();
		
		// findout how many frames are there in the page
		List<WebElement> frames=driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//*[@id='input_0']")).sendKeys("9177240265");;
		driver.findElement(By.xpath("//*[@id='input_1']")).sendKeys("parmeshwarA1!");;
		driver.findElement(By.xpath("//*[@id='loginForm']/div/md-content/button[1]")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		
}}
