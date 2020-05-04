package cs3443;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 * Class created to house main method.
 * 
 * 
 * @author Carla Ramirez
 *
 */
public class Lab3 {
/**
 * Reads input file and parse through input line by line and uses
 * Date class to create date objects which are then passed to 
 * DateRange constructor to create date range objects is both dates are
 * valid.
 * @param args string input
 */
	public static void main(String[] args) {
		// first date to compare
		Date startDate = null;
		// scanner object set to null
		Scanner in = null;

		try {
			in = new Scanner(new File("dates.txt"));
		} catch (FileNotFoundException exception) {
			System.err.println("failed to open dates.txt");
			System.exit(1);
		}
		//continue looping through file until each EOF
		while (in.hasNextLine()) { 
			String line = in.nextLine();
			Date date = new Date(line);
			System.out.println(date);
			//if first date is null then set it to next date
			if (startDate == null) {
				startDate = date;
			} else {
				if (date.isValid()== true && startDate.isValid() == true ) {
					if (startDate.compareTo(date) == -1) {
						DateRange dateRange = new DateRange(startDate, date);
						System.out.println(dateRange);
					}
					//continue to set first date to next date to loop through file
					startDate = date; 
				}
			} //end of else

		}//end of while
	}//end of main
} //end of class
