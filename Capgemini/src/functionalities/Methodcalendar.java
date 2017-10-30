package functionalities;

import java.util.Calendar;
import java.util.Date;

import org.apache.poi.ddf.EscherColorRef.SysIndexSource;

public class Methodcalendar {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		System.out.println(cal.getTimeInMillis());
			
		System.out.println(cal.getCalendarType());
		System.out.println(cal.getTimeZone());

		System.out.println(cal.toString());
	
		cal.set(Calendar.DATE, 21);
		System.out.println(cal.getTime());
		cal.set(Calendar.DAY_OF_MONTH, 22);
		
		System.out.println(cal.getTime());
	
		

		Date day = new Date(00000);
		cal.setTime(day);
		System.out.println("************************************");
		System.out.println(day);
		System.out.println("************************************");
		cal.add(Calendar.DATE,-1);
		System.out.println(cal.getTime());
		System.out.println(cal.getTimeInMillis());
		
		System.out.println(cal.after(day));
		System.out.println(cal.before(day));
		
		cal.clear();
		System.out.println(cal.getTime());
		Object dupli_cal=cal.clone();
		System.out.println(dupli_cal);
		System.out.println(dupli_cal.getClass());
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		System.out.println(cal.getFirstDayOfWeek());
	}

}
