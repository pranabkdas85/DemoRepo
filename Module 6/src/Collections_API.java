import java.util.ArrayList;
import java.util.Hashtable;


public class Collections_API {

	public static void main(String[] args) {
		ArrayList<String> list= new ArrayList<String>();/* ArrayList helps
		 to define the dynamic arrays. */
		list.add("A");   //0
		list.add("B");   //1
		list.add("C");   //2
		System.out.println(list.size());
		System.out.println(list.get(2));
		System.out.println(list.indexOf("B"));
		list.add(3,"E");
		System.out.println(list.contains("A"));
		System.out.println(list.lastIndexOf("C"));
		list.remove(2);
		/* print all of the elements from the array */
		 for (int i=0;i<list.size();i++)
			 System.out.println(list.get(i));
		 
		 /******************HASH TABLE*********************/
		 Hashtable<String, String> table= new Hashtable<String, String>();
		 table.put("name","Pranab");
		 table.put("place","India");
		 table.put("Profession","IT");
		 System.out.println(table.get("name"));
		 }

}
