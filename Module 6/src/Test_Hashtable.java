import java.util.Hashtable;
public class Test_Hashtable {
	public static void main(String [] args)
	{	Hashtable<String,String> table1= new Hashtable<String,String>();
		table1.put("city1","LA");
		table1.put("city2","London");
		table1.put("city3","Delhi");
		
		Hashtable<String,String> table2= new Hashtable<String,String>();
		table2.put("zip1","3453");
		table2.put("zip2","756");
		table2.put("zip3","43534");
		Hashtable<String,Hashtable<String,String>> table= new Hashtable<String,Hashtable<String,String>> ();
		table.put("City",table1);
		table.put("zip",table2);
			
		System.out.println(table.get("City").get("city2"));
	}
}
