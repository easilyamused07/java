package cs3443;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.StringTokenizer;
/**
 * Date class used to parse through input file composed of
 * dates in string format. Check is input date is a valid date or not
 * and compares dates to see if date is before next date. 
 * @author Carla Ramirez
 *
 */
public class Date implements Comparable<Date> {
	//Used to store potential dates in file
	private Serializable date;
	//Used to pass string value of month from index 0 to 3 to monthToInt
	private String strMonth; 
	//1 to 12 used to compare date to other
	private int month; 
	//Days of month used to compare date to other
	private int day; 
	//Year of date used to compare date to other
	private int year; 
	//Used to return valid output toString
	private String str;  
	//Checks is date is valid true or false is invalid date
	private boolean isValid; 
	// parse string input and change to correct date format
	SimpleDateFormat output = new SimpleDateFormat("MMMM d, yyyy"); 
	//Array of different date formats used to parse and validate input
	private SimpleDateFormat[] formats = new SimpleDateFormat[] {

			new SimpleDateFormat("MMMM dd, yyyy"), new SimpleDateFormat("MMM. d, yyyy"),
			new SimpleDateFormat("MMM. dd, yyyy"), new SimpleDateFormat("MMM dd, yyyy"),
			new SimpleDateFormat("MMM d, yyyy"), };
/**
 * Date constructor used to take in file string input then tokenize the
 * input to use for processing the date objects.
 * @param line for string input from file
 */
	public Date(String line) {

		StringTokenizer token = new StringTokenizer(line);
		//manually parse through string into to get month date and year
		strMonth = token.nextToken().substring(0, 3);
		month = monthToInt(strMonth);
		day = Integer.parseInt(token.nextToken().replace(",", ""));
		year = Integer.parseInt(token.nextToken());
		//Loops through array of date formats and throws exception if date is invalid
		for (SimpleDateFormat format : formats) {

			try {
				format.setLenient(false);
				date = format.parse(line);
			} catch (ParseException e) {
				// try more possible date formats
			}
		}
		isValid = true; // input successfully parsed valid date
	}
/**
 * Compares two date objects to each other using the month
 * day and year to determine if this date is before other date.
 * If this date is before other date then a DateRange object is created from 
 * both dates.
 * @param other date
 * @return -1 is this date before other, 1 is this date after other, and 0 if equal
 */
	public int compareTo(Date other) {
		if (year < other.getYear()) {
			return -1;
		} else if (year > other.getYear()) {
			return 1;
		} else {
			if (month < other.getMonth()) {
				return -1;
			} else if (month > other.getMonth()) {
				return 1;
			} else {
				if (day < other.getDay()) {
					return -1;
				} else if (day > other.getDay()) {
					return 1;
				} else {
					return 0;
				}
			}
		}
	}
/**
 * Checks input file month names from index 0 to 3
 * and if upper or lower case date returns the numeric version
 * of that month.
 * @param month name of month
 * @return integer version of month
 */
	public int monthToInt(String month) {
		//Validates entire year January to December
		if (month.equals("Jan") || month.equals("jan")) {
			return 1;
		} else if (month.equals("Feb") || month.equals("feb")) {
			return 2;
		} else if (month.equals("Mar") || month.equals("mar")) {
			return 3;
		} else if (month.equals("Apr") || month.equals("apr")) {
			return 4;
		} else if (month.equals("May") || month.equals("may")) {
			return 5;
		} else if (month.equals("Jun") || month.equals("jun")) {
			return 6;
		} else if (month.equals("Jul") || month.equals("jul")) {
			return 7;
		} else if (month.equals("Aug") || month.equals("aug")) {
			return 8;
		} else if (month.equals("Sep") || month.equals("sep")) {
			return 9;
		} else if (month.equals("Oct") || month.equals("oct")) {
			return 10;
		} else if (month.equals("Nov") || month.equals("nov")) {
			return 11;
		} else if (month.equals("Dec") || month.equals("dec")) {
			return 12;
		} else {
			return -1; //default invalid value
		}
	}
/**
 * Getter for date objects months integer value
 * @return months integer value
 */
	public int getMonth() {
		return month;
	}
/**
 * Setter for months
 * @param month integer value
 */
	public void setMonth(int month) {
		this.month = month;
	}
/**
 * Getter for days value
 * @return days integer value
 */
	public int getDay() {
		return day;
	}
/**
 * Setter for day value
 * @param day integer value
 */
	public void setDay(int day) {
		this.day = day;
	}
/**
 * Getter for year integer value
 * @return year integer value
 */
	public int getYear() {
		return year;
	}
/**
 * Setter for year value
 * @param year integer value
 */
	public void setYear(int year) {
		this.year = year;
	}
/**
 * Returns true if date is valid or false is invalid date
 * @return true or false
 */
	public boolean isValid() {
		return isValid;
	}
/**
 * Setter for date verification true or false
 * @param valid date
 */
	public void setValid(boolean valid) {
		this.isValid = valid;
	}
/**
 * Used to override java toString() and return correct output
 * uses simpledateformater to print dates or prints "Invalid Date" is
 * not a valid date.
 * @return prints dates in correct format
 */
	public String toString() {
		try {
			str = "Date: " + output.format(date);

		} catch (IllegalArgumentException e) {
			str = "Invalid Date";
			isValid = false;
		}
		return str;
	}
}//end of class
