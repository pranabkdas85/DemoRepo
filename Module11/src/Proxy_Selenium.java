import org.openqa.selenium.Proxy;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Proxy_Selenium {

	public static void main(String[] args) {
		
		Proxy p = new Proxy();
		p.setProxyAutoconfigUrl("http://someproxyserver.com");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.PROXY, p);
		
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");

		FirefoxDriver dr = new FirefoxDriver(cap);
	}

}
