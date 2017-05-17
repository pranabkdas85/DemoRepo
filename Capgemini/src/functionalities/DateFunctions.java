package functionalities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFunctions {

	public static void main(String[] args) {
	Date d= new Date();
	System.out.println(d);
	
	Date d0= new Date(0);
	System.out.println(d0);
	
	Date d1= new Date(100000);
	System.out.println(d1);
	
	System.out.println(d.after(d1));
	System.out.println(d.before(d1));

	System.out.println(d.clone());
	System.out.println(d.compareTo(d1));
	
	System.out.println(d.toString());
	
	String currentmonth = new SimpleDateFormat("MMMM").format(d);
	String currentyear = new SimpleDateFormat("yyyy").format(d);
	String currentday = new SimpleDateFormat("d").format(d);
	
	System.out.println(currentday+ currentmonth + currentyear);

	}

}
