package cs3443;

import java.io.*;
import java.util.Scanner;

/**
 * The FileCounts Class reads through a file and counts the number of lines,
 * words, characters,bytes in the file.
 * 
 * @author Carla Ramirez
 *
 */
public class FileCounts {
	// instance of file
	private File file;

	/**
	 * File used to process counts
	 * 
	 * @param file
	 *            file to be parsed
	 */
	public FileCounts(File file) {
		this.file = file;
	}

	/**
	 * Counts the number of lines in a file
	 * 
	 * @return number of lines in a file
	 * @throws FileNotFoundException
	 */
	public int lineCount() throws FileNotFoundException {

		int count = 0;
		Scanner in = new Scanner(this.file);
		while (in.hasNextLine()) {
			count++;
			in.nextLine();
		}
		in.close();
		return count;
	}

	/**
	 * Counts the number of words (tokens) in a file
	 * 
	 * @return the number of words in a file
	 * @throws FileNotFoundException
	 */
	public int tokenCount() throws FileNotFoundException {

		int count = 0;
		Scanner in = new Scanner(this.file);
		while (in.hasNext()) {
			count++;
			in.next();
		}
		in.close();
		return count;
	}

	/**
	 * Counts the number of characters in a file
	 * 
	 * @return number of characters in a file
	 * @throws IOException
	 */
	public int charCount() throws IOException {

		int count = 0;
		FileReader reader = new FileReader(this.file);
		while (reader.read() != -1) {
			count++;
		}
		reader.close();
		return count;
	}

	/**
	 * Count the number of bytes in a file
	 * 
	 * @return number of bytes in a file
	 * @throws IOException
	 */
	public int byteCount() throws IOException {

		int count = 0;
		FileInputStream stream = new FileInputStream(this.file);
		while (stream.read() != -1) {
			count++;
		}
		stream.close();
		return count;
	}
} // end of class
