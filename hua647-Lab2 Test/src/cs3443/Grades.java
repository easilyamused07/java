package cs3443;

import java.util.*;

public class Grades {
/**<h1> Grades class </h1>
 *      This class processes each student and their grades to 
 *      calculate various results. i.e. average, median, max etc.
 *      
 * @author Carla Ramirez     
 *     
 */
    private String name; //instance variable for student names
    private int[] grades; //instance variable for student grades
/**<h1>toString</h1>
 *      This method returns a string does not take any parameters
 *it replaces java.lang toString function for getName() and getGrades()
 * 
 */
    public String toString() {
        String str = getName() + " ";
        str += getGrades();
        return str;
    }
/**<h1> inputGrade</h1>
 *      Takes grades from input file and stores them in an array
 * 
 * @param in takes scanner input
 */
    public void inputGrade(Scanner in) {

        grades = new int[1];
        int cnt = 0;

        while (in.hasNextInt()) {
            int grade = in.nextInt();
            // if need to double the size of the array
            if (cnt == grades.length) {
                grades = Arrays.copyOf(grades, 2 * grades.length);
            }
            grades[cnt] = grade;
            cnt++;
            // place each grade into an array
            int[] gradeArray = new int[cnt];
            for (int i = 0; i < cnt; i++) {
                gradeArray[i] = grades[i];
            }
            grades = gradeArray; // copy grades into array
        }
    }
/** <h1> getGrades </h1>
 *      Converts int array to String using java Arrays methods
 * 
 * @return String of students grades
 */
    public String getGrades() {
        //convert int array to a string
        String stringGrades = Arrays.toString(grades);
        return stringGrades;
    }
/**<h1> length </h1>
 *      Counts how many grades each student has
 * @return total grades student has
 */
    public int length() {
        int length = grades.length;
        return length;
    }
/**<h1>getName</h1>
 *      Students name
 * @return students name
 */
    public String getName() {
        return name;
    }
/**<h1>setName</h1>
 *      Sets each student name based on input data from file
 *
 * @param name students name
 */
    public void setName(String name) {
        this.name = name;
    }
/**<h1>average</h1>
 *      Calculates the average of each students grades
 * @return average of students grades
 */
    public double average() {
        int total = 0;
        int i = 0;
        while (i < grades.length) {
            int grade = grades[i];
            //sum of grades
            total += grade;
            i++;
        }
        return (double) total / grades.length;
    }
/**<h1>median</h1>
 *      Calculates the median of each student based on grades
 * @return the median of grade
 */
    public double median() {
        double median = 0;
        Arrays.sort(grades);
        // if length of array is even
        if(grades.length % 2 == 0){
            int pos1 = (grades.length - 1) / 2;
            int pos2 = grades.length / 2;
            median = (double) (grades[pos1] + grades[pos2]) / 2;
        } else {
            // if length of array is odd
            int pos = (grades.length - 1) / 2;
            median = grades[pos];
        }
        return median;
    }
/**<h1>maximum</h1>
 *      Gets the max grade for each student
 * @return the max grade
 */
    public int maximum() {
        int max = grades[0];
        // loop through each grade in array and check if > previous
        for (int grade : grades) {
            if (grade > max)
                max = grade;
        }
        return max;
    }
/**<h1>minimum</h1>
 *      Gets the min grade for each student
 * @return the minimum grade 
 */
    public int minimum() {
        int min = grades[0];
        // for each grade in array check if < previous
        for (int i = 0; i < grades.length; i++) {
            int grade = grades[i];
            if (grade < min)
                min = grade;
        }
        return min;
    }
} //end of class
