package functionalities;

import java.lang.reflect.Array;
import java.util.Arrays;

public class onedarray {

	public static void main(String[] args) {
		String[] arr = new String[2];
		arr[0] = "test1";
		arr[1] = "test1";
		System.out.println(Arrays.toString(arr));
		// System.out.println(Arrays.asList(arr));// this is returning as String
		// Array

		StringBuilder SB = new StringBuilder();
		SB.toString();
		for (int i = 0; i < arr.length; i++) {
			SB.append(arr[i] + ",");
		}
		System.out.println(SB);
		System.out.println(SB.getClass());

		String result = SB.toString();
		System.out.println(result.getClass());
		// In array it is mandatory to define the length of an array before
		// decribing
		// String[] def=new String[]; wrong as the length is not defined.
		String[] abc = null;// correct
		abc = new String[6];// correct as we are defining the length.

	}

}
