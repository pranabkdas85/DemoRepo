import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Calen_MakeMyTrip {
	static WebDriver driver;

	public static void main(String[] args) throws ParseException {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");

		driver.findElement(By.xpath("//*[@id='hp-widget__depart']")).click();
		selectDate("19/08/2017");

	}

	public static void selectDate(String date) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date dateToBeSelected = df.parse(date);

		Date currentDate = new Date();
		String yeardisplayed;
		String monthdisplayed;

		String currentmonth = new SimpleDateFormat("MMMM").format(currentDate);
		String currentyear = new SimpleDateFormat("yyyy").format(currentDate);
		String currentday = new SimpleDateFormat("d").format(currentDate);

		String monthtobeselected = new SimpleDateFormat("MM").format(dateToBeSelected);
		String yeartobeselected = new SimpleDateFormat("yyyy").format(dateToBeSelected);
		String daytobeselected = new SimpleDateFormat("d").format(dateToBeSelected);
		System.out.println(monthtobeselected + yeartobeselected + daytobeselected);
		while (true) {// selecting year
			yeardisplayed = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[2]")).getText();
			if (yeardisplayed.equals(yeartobeselected)) {
				break;

			} else if (Integer.parseInt(yeardisplayed) < Integer.parseInt(yeartobeselected)) {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			}
		}
		while (true) {// selecting month
			monthdisplayed = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[1]")).getText();
			
			if (Integer.parseInt(monthStringtoint(monthdisplayed)).equals(Integer.parseInt(monthtobeselected)))
				break;
			else if (Integer.parseInt(monthStringtoint(monthdisplayed)) < Integer.parseInt(monthtobeselected)) {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			}
		}
		
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td[@data-month='4']/a[text()='"+ daytobeselected+"']")).click();
			

		}
	

	public static String monthStringtoint(String month) {
		String monthStringtoint = null;
		if (month.equals("JANUARY"))
			monthStringtoint = "01";
		else if (month.equals("FEBRUARY"))
			monthStringtoint = "02";
		else if (month.equals("MARCH"))
			monthStringtoint = "03";
		else if (month.equals("APRIL"))
			monthStringtoint = "04";
		else if (month.equals("MAY"))
			monthStringtoint = "05";
		else if (month.equals("JUNE"))
			monthStringtoint = "06";
		else if (month.equals("JULY"))
			monthStringtoint = "07";
		else if (month.equals("AUGUST"))
			monthStringtoint = "08";
		else if (month.equals("SEPTEMBER"))
			monthStringtoint = "09";
		else if (month.equals("OCTOBER"))
			monthStringtoint = "10";
		else if (month.equals("NOVEMBER"))
			monthStringtoint = "11";
		else if (month.equals("DECEMBER"))
			monthStringtoint = "12";

		return monthStringtoint;
	}
}
