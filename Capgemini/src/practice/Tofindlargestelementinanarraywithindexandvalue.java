package practice;

import java.util.Random;

public class Tofindlargestelementinanarraywithindexandvalue {

	public static void main(String[] args) {

		int[] array = new int[20];
		// create an array
		Random r = new Random();
		for (int i = 0; i < array.length; i++) {
			double d = r.nextDouble() * 100;
			array[i] = (int) d;
			System.out.println(array[i]);
		}

		// find the largest number from the array
		int largest = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] > largest)
				largest = array[i];
		}
		System.out.println("The largest element is :" + largest);

		for (int i = 0; i < array.length; i++) {
			if (array[i] == largest)
				System.out.println("The index for the largest number is :" + i);

		}
	}
}
