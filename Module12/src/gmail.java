import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class gmail {

	public static void main(String[] args) {
		WebDriver driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://accounts.google.com/ServiceLogin?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1#identifier");
		//driver.findElement(By.id("Email")).sendKeys("pranabk.das85");
		driver.findElement(By.xpath("//*[@id='Email' and @name='Email' and @placeholder='Email or phone']")).sendKeys("pranabk.das85");
		driver.findElement(By.id("next")).click();
		WebElement Signin = driver.findElement(By.id("signIn"));
		String type = Signin.getAttribute("type");
		System.out.println(type);
		/*int x= Signin.getLocation().x;
		int y= Signin.getLocation().y;
		System.out.println(x+"-------------"+y);
		*/
		int x=driver.findElement(By.xpath("html/body/div[1]/div[2]/div[1]/h2")).getLocation().x;
		int y=driver.findElement(By.xpath("html/body/div[1]/div[2]/div[1]/h2")).getLocation().y;
		System.out.println(x+"-------------"+y);
	}

}
