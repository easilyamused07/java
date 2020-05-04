import java.util.Arrays;
import java.util.Random;

/** Provides methods and capabilities to sort arrays of equal size
 * between threads and print them out in ascending order.
 * @author Carla Ramirez
 * */
public class SortingThread implements Runnable {
	
	/** Designates which thread number this SortingThread class belongs to*/
	private int threadNumber;
	
	/** The array of numbers to be sorted in this thread.*/
	private int[] arrayToSort;
	
	/** SortingBuffer class which provides thread methods to wait and
	 * notify threads on sort.*/
	private SortingBuffer buffer;

	/** This class is used to sort arrays between multiple threads. For
	 * each thread being called, this class identifies the thread number, 
	 * it is given an array of equal size on other threads utilizing this class
	 * and provides access to the SortingBuffer class which allows access
	 * to methods that provide notification methods on sort between threads. 
	 * Additionally, it will sort the array before any other operations are
	 * performed.
	 * @param threadNumber ID of the thread being executed.
	 * @param arrayToSort Array to be sorted in between threads.
	 * @param buffer SortingBuffer class which provides access to thread
	 * methods to allow sorting between arrays in multiple threads.*/
	public SortingThread(int threadNumber, int[] arrayToSort, 
			SortingBuffer buffer) {
		this.threadNumber = threadNumber;
		this.arrayToSort = arrayToSort;
		Arrays.sort(this.arrayToSort);
		this.buffer = buffer;
	}

	/** Default method executed when class is created in a thread manner. 
	 * It will first print out all array values in the given array in an
	 * unsynchronized manner. It will then print out the values in the array
	 * in ascending order when compared to values in an array in a separate 
	 * thread.
	 * */
	@Override
	public void run() {
			try {
				if(this.threadNumber != 0)
					Thread.sleep(new Random().nextInt(500));
				for(int value : this.arrayToSort){
					System.out.println(this.threadNumber + " unsynchronized " 
							+ value);
				}
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		
			for(int value : this.arrayToSort){
				try {
					buffer.waitUntilMinimum(this.threadNumber, value);
					System.out.println(this.threadNumber + " synchronized " 
							+ value);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			buffer.finished(this.threadNumber);
	}

}