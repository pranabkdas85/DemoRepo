package functionalities;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Dummy {

	public static void main(String[] args) {
		Date formattedDate = null;
		Date formattedyesterday = null;
		Date dateNow = null;
		Date d = new Date();
		SimpleDateFormat datetimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("The current time before simpledateformat is " + d);
		String nowdate = datetimeFormat.format(d);
		System.out.println("The current time after changing it to Simpledatetimeformat (String)  is " + nowdate);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		Date yesterday = cal.getTime();
		System.out.println("Yesterdays date without simpledateformat is " + yesterday);
		System.out.println(datetimeFormat.format(yesterday));

		try {
			formattedDate = datetimeFormat.parse(nowdate);
			// formattedyesterday=newdateFormat.
			System.out.println("The current time after parse is " + formattedDate);
			System.out.println("Current time in miliseconds" + formattedDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
