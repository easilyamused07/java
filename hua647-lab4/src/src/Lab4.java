package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import length.Length;
import length.Foot;
import length.Inch;
import length.Meter;
import length.Yard;
/**
 * Name:Lab4
 * Manage the inherited methods from Length.java superclass and subclasses
 * Convert and print length values
 * @author Carla Ramirez
 *
 */
public class Lab4 {
	//initialize current max length value
	static Length currMaxLen = null;
	//initialize current min length value
	static Length currMinLen = null;
	
//instance variables for length types
	static Inch inch;
	static Foot foot;
	static Yard yard;
	static Meter meter;
/**
 * 
 * Open, read, close data.txt file. Parse the data line by line and based on
 * input from file convert to the correct length type and add to an array of various length types.
 * Iterate through array and take each of the length value and add them to other length.
 * Return the printed values of each length type, minimum length, maximum length, and sum from 
 * first to last and sum from last to first of array.
 * 
 * @param args default
 */
	public static void main(String[] args) {

		Scanner in = null;
		try {
			in = new Scanner(new File("data.txt"));
		} catch (FileNotFoundException exception) {
			throw new RuntimeException("failed to open data.txt");
		}
		ArrayList<Length> lengths = new ArrayList<Length>();
		// convert length to correct length object
		while (in.hasNextDouble()) {
			double value = in.nextDouble();
			String unit = in.next();
			Length length = getLengthType(value, unit);
			// based on input add length to array
			if (length != null) {
				lengths.add(length);
				System.out.println(length);

				if (currMaxLen == null && currMinLen == null) {
					currMaxLen = length;
					currMinLen = length;
				}
				if (length.compareTo(currMaxLen) == 1) {
					currMaxLen = length;
				} else if (length.compareTo(currMinLen) == -1) {
					currMinLen = length;
				}
			}

		}
		System.out.println("\nMinimum is " + currMinLen);
		System.out.println("Maximum is " + currMaxLen);

		// initialize all lengths to zero for summing
		initializeLens();

		int i = 0;
		// Iterate over list from beginning to end.
		while (i < lengths.size()) {
			// Load the value from the list into a temporary object
			// to avoid repeatedly calling it from the array.
			Length currLength = lengths.get(i);
			// Add the length into each Length subclass.
			inch.add(currLength);
			foot.add(currLength);
			yard.add(currLength);
			meter.add(currLength);
			i++;
		}
		//print length sums starting from first value in array to last value
		System.out.println("\nSum of Lengths Adding from First to Last");
		printSums(meter);
		printSums(inch);
		printSums(foot);
		printSums(yard);

		// Re-initialize lengths back to zero
		initializeLens();
		// Set new value for index to iterate in reverse over the list.
		i = (lengths.size() - 1);
		// Add each value in lengths to each temporary subclass in reverse
		// order.
		while (i >= 0) {
			// Create temporary container for repeated use within loop.
			Length currLength = lengths.get(i);
			inch.add(currLength);
			foot.add(currLength);
			yard.add(currLength);
			meter.add(currLength);
			i--;
		}
		//print the sums of lengths starting from last length in array to first
		System.out.println("\nSum of Lengths Adding from Last to First");
		printSums(meter);
		printSums(inch);
		printSums(foot);
		printSums(yard);

		in.close(); // close data file
	}
/**
 * 
 * Check the first three characters of string from data from data.txt file.
 * If first three characters match first three characters of a valid length type
 * e.g.  inch, yard, foot, meter then return that length type.
 * @param value of length
 * @param unit of length
 * @return length type
 */
	private static Length getLengthType(double value, String unit) {

		String unitType = unit;
		// validate if string input is a valid length type
		if (unitType.substring(0, 3).equalsIgnoreCase("met"))
			return new Meter(value);
		else if (unitType.substring(0, 3).equalsIgnoreCase("yar"))
			return new Yard(value);
		else if (unitType.substring(0, 3).equalsIgnoreCase("foo") || unitType.substring(0, 3).equalsIgnoreCase("fee"))
			return new Foot(value);
		else if (unitType.substring(0, 3).equalsIgnoreCase("inc"))
			return new Inch(value);
		else
			return null; //default value if not valid length type
	}

	/**
	 * 
	 * Prints the sums of lengths based on length type requested. e.g.
	 * yard, inch, meter, foot
	 * 
	 * @param type of length
	 */
	private static void printSums(Length type) {
		System.out.println(type);

	}

	/**
	 * 
	 *Set all lengths to zero via Length.java subclasses methods, used for summing
	 */
	public static void initializeLens() {
		inch = new Inch(0.0);
		foot = new Foot(0.0);
		yard = new Yard(0.0);
		meter = new Meter(0.0);

	}

}
