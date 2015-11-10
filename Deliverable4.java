import java.util.Random;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.lang.System;

public class Deliverable4 {

	public int[] randomArray() {
		Random rand = new Random();
		int randomSize;
		int randomInt;

		randomSize = rand.nextInt((100 - 0) + 1) + 0;
		int[] arr = new int[randomSize];


		for(int i = 0; i < randomSize; i++) {
			randomInt = rand.nextInt((100 - 0) + 1) + 0;
			arr[i] = randomInt;
		}
		
		return arr;

	}

	// Ensures that arrays are properly sorted when going through Arrays.sort()
	@Test
	public void sortWholeArray() {

		int testNumber = 0;
		while(testNumber < 100) {
			int[] randArray = randomArray();

			Arrays.sort(randArray);

			for(int i = 0; i < randArray.length - 1; i++) {
				assertTrue(randArray[i] <= randArray[i + 1]);
			}
			testNumber++;
		}
	}

	// Ensures that array subsets are properly sorted when going through Arrays.sort()
	@Test
	public void sortPartOfArray() {
		Random rando = new Random();
		int testNumber = 0;
		while(testNumber < 100) {
			int[] randArray = randomArray();
			int length = randArray.length;
			int from = rando.nextInt((randArray.length - 0) + 1) + 0;
			int to = rando.nextInt((randArray.length - 0) + 1) + 0;

			if(from > to) {
				int temp = from;
				from = to;
				to = temp;
			}
			//System.out.println(from + " to " + to);

			Arrays.sort(randArray, from, to);

			for(int i = from; i < to - 1; i++) {
				assertTrue(randArray[i] <= randArray[i + 1]);
			}
			testNumber++;
		}
	}
	
	///
	// Each time an array is randomly generated, a copy of that array is made.
	// Both of the arrays are then sorted.
	// Ensures that two arrays with the same contents are sorted similarly.
	@Test
	public void arraySortedTwice() {

		int testNumber = 0;
		while(testNumber < 100) {
			int[] randArray = randomArray();
			int[] copy = new int[randArray.length];

			System.arraycopy(randArray, 0, copy, 0, randArray.length);

			Arrays.sort(randArray);
			Arrays.sort(copy);

			for(int i = 0; i < randArray.length; i++) {
				assertTrue(randArray[i] == copy[i]);
			}
			testNumber++;
		}
	}


}
