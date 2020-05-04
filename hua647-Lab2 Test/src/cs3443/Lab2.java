package cs3443;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**<h1> Lab2 class</h1>
 *Description:
 *      This class reads in a text file called data.txt which
 * contains pairs of lines: the first line of each pair is the name
 * of the student, and the second are the list of grades. This class
 * uses methods from Grades class and stores data into objects to be processed.
 * 
 * Sample input:
 *      Carla
 *      87 99 96 99 
 *       
 * Sample output:
 *       Carla [87, 99, 96, 99]
 *       Name:  Carla
 *       Length: 4
 *       Average: 95.25
 *       Median: 96.0
 *       Maximum: 99
 *       Minimum: 87
 
 * @author Carla Ramirez
 * 
 */
public class Lab2 {
 /**<h1> Main </h1>
  *     The main method is responsible for opening the data file and
  * assigning the name and grades of each student to objects from 
  * Grades class. It then calls testGrades method to print the values
  * of each student and grades. Finally it closes the file.
  * 
  * @param args input arguments for main
  */
    public static void main(String[] args) {

        Scanner input = null; // initialize input to be null
        Grades student = new Grades(); // Grades class object
        String name = ""; // initialize variable for name to be blank

        try {
            input = new Scanner(new File("data.txt"));
        } catch (FileNotFoundException exception) {
            System.err.println("failed to open data.txt");
            System.exit(1);

        }
        // continue to read in tokens until EOF
        while (input.hasNext()) {
            name = input.next();
            // Grades method to parse grades and save in array of integers
            student.inputGrade(input);    
            student.setName(name);
            // print the results for each student
            testGrades(student);
        }
        input.close(); // close input file
    }
/**<h1>testGrades</h1>
 *      This method uses objects from class Grades to call methods that
 * return data for each student. Each student's name grades, averages,
 * median, maximum, and minimum grades are displayed in specific format.     
 *     
 * @param grades object from Grades class used to access Grades methods
 */
    public static void testGrades(Grades grades) {
        //prints results of each student
        System.out.println(grades.toString());
        System.out.printf("\tName:    %s\n", grades.getName());
        System.out.printf("\tLength:  %d\n", grades.length());
        System.out.printf("\tAverage: %.2f\n", grades.average());
        System.out.printf("\tMedian:  %.1f\n", grades.median());
        System.out.printf("\tMaximum: %d\n", grades.maximum());
        System.out.printf("\tMinimum: %d\n", grades.minimum());
    }
}