package functionalities;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Collections {

	public static void main(String[] args) {

		ArrayList<String> arraylist= new ArrayList<String>();
		arraylist.add("Pranab");
		arraylist.add("Kumar");
		arraylist.add("Das");
		
		System.out.println(arraylist.size());
		System.out.println(arraylist.get(0));
		System.out.println(arraylist.isEmpty());
		System.out.println(arraylist.iterator());
		System.out.println(arraylist.contains("Pranab"));
		System.out.println(arraylist.remove("Das"));
		System.out.println(arraylist.size());
		arraylist.add("Das");
		System.out.println(arraylist.lastIndexOf("Kumar"));
		
		ArrayList<Integer> arraylistint= new ArrayList<Integer>();
		
	
		
		
	}

}
