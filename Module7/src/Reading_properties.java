import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Reading_properties {
	public static void main(String[] args) throws IOException{
	Properties prop= new Properties();
	FileInputStream ip= new FileInputStream("C:\\Users\\Admin\\workspace\\Module 7\\src\\Config\\employee.properties");
	prop.load(ip);
	String Name= prop.getProperty("name");
	String dirname = System.getProperty("user.dir");
	System.out.println(Name);
	System.out.println(dirname);
	}

}
