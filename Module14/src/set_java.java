import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class set_java {

	public static void main(String args[]){
		// no duplicate element
		// no index
		// no order
		Set<String> s = new HashSet<String>();
		System.out.println(s.size());
				s.add("table");
				s.add("pen");
				s.add("pencil");
				s.add("eraser");
				System.out.println(s.size());
				s.add("eraser");
				System.out.println(s.size());
				
				//System.out.println(s.get(0));
				
				Iterator<String> it = s.iterator();
				/*
				System.out.println(it.next());
				System.out.println(it.next());
				System.out.println(it.next());
				System.out.println(it.next());
				*/
				while(it.hasNext())
					System.out.println(it.next());
					
				
	}
}
