import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Rediff_table {
public static void main(String args[]){
	
	WebDriver driver= new ChromeDriver();
	
	System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
	System.setProperty("webdriver.ie.driver","C:\\IEDriverServer.exe");
	
	
	driver.get("http://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		
	List<WebElement> Company_names=driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));
	List<WebElement> Current_price =driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[4]"));
	System.out.println("Total Number of Company Names are : " + Company_names.size());
	/*
	  String Comp= "IFCI Ltd.";
	for (int i=0;i<Company_names.size();i++){
		System.out.print(Company_names.get(i).getText());
		System.out.println(Current_price.get(i).getText());
		*/
	
	/*
	for (int i=0;i<Company_names.size();i++){
		if (Comp.equals(Company_names.get(i).getText())){
		System.out.println(" The Comapny " + Company_names.get(i).getText() +" is having Price as "+Current_price.get(i).getText());
		}break;
		
	}*/
	
	System.out.println("Rows "+ driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr")).size());
	System.out.println("Columns "+ driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td")).size());
	System.out.println("Cells "+ driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td")).size());
	
	int rows=driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]")).size();
	int colm=driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td")).size();
	for(int i=1;i<=rows;i++){
		for (int j=1;j<=colm;j++){
			System.out.print(driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+i+"]/td["+j+"]")).getText() + "-----");
	}
		System.out.println("");
}
}}
