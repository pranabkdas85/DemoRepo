import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Gmail_CSS_Selectors {

	public static void main(String[] args) {
		WebDriver driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://accounts.google.com/ServiceLogin?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1#identifier");
		//driver.findElement(By.cssSelector("*[id='Email']")).sendKeys("Test");
		//driver.findElement(By.cssSelector("input[name='Email']")).sendKeys("text");
		//driver.findElement(By.cssSelector("input[name='Email'][id='Email'][placeholder='Enter your email']")).sendKeys("Text");
		//String heading = driver.findElement(By.cssSelector("*[class='banner'] h1")).getText();
		/*String heading = driver.findElement(By.cssSelector("div[class='banner'] h1")).getText();
		System.out.println(heading);
		*/
		//driver.findElement(By.cssSelector("*[id^='Ema']")).sendKeys("Test");
		//driver.findElement(By.cssSelector("*[id$='mail']")).sendKeys("Test");
		driver.findElement(By.cssSelector("*[id*='mail']")).sendKeys("Test");
		
		}
}
