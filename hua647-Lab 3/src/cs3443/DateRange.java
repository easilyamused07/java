package cs3443;
/**
 * Class to create date range objects to return a date range
 * if this date before other date.
 * @author Carla Ramirez
 *
 */
public class DateRange {
    //First date to compare
    private Date date1;
    //Used for toString
    private String str;
    //Second date to compare
    private Date date2;
/**
 * Creates a date range object composed of two valid dates.
 * @param start first date object
 * @param end second date object
 */
    public DateRange(Date start, Date end){
       //set incoming date object value to class instance variables 
       this.date1 = start;
       this.date2 = end;
       
    }  
    /**
     * Overrides java toString method and return
     * date range object in correct format.
     * @return date range object in string format
     */
    public String toString(){
        
        if(this.date1 != null && this.date2 != null){
            str = "DateRange: " + this.date1
                    + " - " + this.date2;
        }
        return str;
    } // end of toString
 
}//end of class
