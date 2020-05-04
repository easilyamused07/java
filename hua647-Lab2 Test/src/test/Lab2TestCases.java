/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cs3443.Grades;

/**
 * Lab2TestCases contains 12 simple test cases to test Lab2 Grade class
 * implementation Expects All test cases pass
 * 
 * @author Carla Ramirez
 *
 */
public class Lab2TestCases {

	private Grades g;

	/**
	 * Throws exception if at set up there is an error
	 * @throws java.lang.Exception NULL Pointer
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Throws exception if at set up there is an error
	 * @throws java.lang.Exception NULL Pointer
	 */
	@Before
	public void setUp() throws Exception {

		g = new Grades();
	}

	/**
	 * testAverage3Values : test simple average of 50, 65, 67 rounded to 2 dec.
	 * digits expects 60.67
	 */

	@Test
	public void testAverage3Values() {
		String grades = "50 65 67";
		g.inputGrade(new Scanner(grades));
		assertEquals("60.67", String.format("%.2f", g.average()));
	}

	/**
	 * testAverageEmptyArray : calc average on empty grade array expects some
	 * kind of exception (NullPointerException but maybe not best way to
	 * communicate the error)
	 */
	@Test(expected = NullPointerException.class)
	public void testAverageEmptyArray() {
		assertEquals("60.67", String.format("%.2f", g.average()));
	}

	/**
	 * testAverageTwoValues : calc average on 10 and 15 rounded to two digits
	 * after decimal expects 12.50
	 */
	@Test
	public void testAverage2Values() {
		String grades = "10 15";
		g.inputGrade(new Scanner(grades));
		assertEquals("12.50", String.format("%.2f", g.average()));
	}

	/**
	 * testAverage4SameValues : calc average on 7, 7, 7, and 7 rounded to two
	 * digits after decimal expects 7
	 */
	@Test
	public void testAverage4SameValues() {
		String grades = "7 7 7 7";
		g.inputGrade(new Scanner(grades));
		assertEquals("7.00", String.format("%.2f", g.average()));
	}

	/**
	 * testMedian3Values : test simple median of 50, 65, 67 rounded to 2 dec.
	 * digits expects 65.00
	 */

	@Test
	public void testMedian3Values() {
		String grades = "50 65 67";
		g.inputGrade(new Scanner(grades));
		assertEquals("65.00", String.format("%.2f", g.median()));
	}

	/**
	 * testMedianEmptyArray : calc median on empty grade array expects some kind
	 * of exception (NullPointerException but maybe not best way to communicate
	 * the error)
	 */
	@Test(expected = NullPointerException.class)
	public void testMedianEmptyArray() {
		assertEquals("60.67", String.format("%.2f", g.median()));
	}

	/**
	 * testMedianTwoValues : calc median on 10 and 15 rounded to two digits
	 * after decimal expects 12.50
	 */
	@Test
	public void testMedian2Values() {
		String grades = "10 15";
		g.inputGrade(new Scanner(grades));
		assertEquals("12.50", String.format("%.2f", g.median()));
	}

	/**
	 * testMedian4SameValues : calc median on 7, 7, 7, and 7 rounded to two
	 * digits after decimal expects 7.00
	 */
	@Test
	public void testMedian4SameValues() {
		String grades = "7 7 7 7";
		g.inputGrade(new Scanner(grades));
		assertEquals("7.00", String.format("%.2f", g.median()));
	}

	/**
	 * testMinimum3Values : test minimum of 50, 65, 67 expects 50
	 */

	@Test
	public void testMinimum3Values() {
		String grades = "50 65 67";
		g.inputGrade(new Scanner(grades));
		assertEquals("50", String.format("%d", g.minimum()));
	}

	/**
	 * testMinimumEmptyArray : calc minimum on empty grade array expects some
	 * kind of exception (NullPointerException but maybe not best way to
	 * communicate the error)
	 */
	@Test(expected = NullPointerException.class)
	public void testMinimumEmptyArray() {
		assertEquals("60", String.format("%d", g.minimum()));
	}

	/**
	 * testMinimumTwoValues : calc minimum on 10 and 15 expects 10
	 */
	@Test
	public void testMinimum2Values() {
		String grades = "10 15";
		g.inputGrade(new Scanner(grades));
		assertEquals("10", String.format("%d", g.minimum()));
	}

	/**
	 * testMinimum4SameValues : calc minimum on 7, 7, 7, and 7 expects 7
	 */
	@Test
	public void testMinumum4SameValues() {
		String grades = "7 7 7 7";
		g.inputGrade(new Scanner(grades));
		assertEquals("7", String.format("%d", g.minimum()));
	}

}
