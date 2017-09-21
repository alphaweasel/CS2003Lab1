package labOne;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * CS 2003 - Lab 1. Code to compute the average of doubles from an input
 * file.  NOTE: add data members and methods at your convenience. Use
 * the most accurate data types. You can reuse bits of code from
 * the class Lab1a.
 *
 * @author Garrison Henkle
 * @since 8-31-17
 * @version 1.8
 */

import java.util.Scanner;

public class Lab1b {

	// data members

	/**
	 * Constructor: calls method readFile that reads the doubles contained in the
	 * file "<code>filename</code>" and computes the average of the elements.
	 * 
	 * @param filename
	 *            name of the file containing the doubles.
	 */
	public Lab1b(String filename) {
		readFile(filename);
	}

	/**
	 * Reads double from a file named <code>filename</code> and computes the average
	 * of the elements contained in the file
	 * 
	 * @param filename
	 *            name of the file containing the doubles
	 */
	public void readFile(String filename) {
		try {
			// create the file (inputFile), scanner for the file (input), and an ArrayList
			// to hold the doubles (doubleList)
			File inputFile = new File(filename);
			Scanner input = new Scanner(inputFile);
			ArrayList<Double> doubleList = new ArrayList<Double>();

			// variable for the doubles imported by the scanner
			double doubleInput;

			// while there are more doubles, read the double from the file and add it to the
			// ArrayList doubleList
			while (input.hasNextDouble()) {
				doubleInput = input.nextDouble();
				doubleList.add(doubleInput);
			}

			input.close(); // close the scanner

			double average = 0.0; // holds the output average
			int numCounter = 0; // counts the total number of elements in doubleList
			double sum = 0.0; // holds the sum of the doubles added together

			// calculates the sum of the numbers and the total amount of numbers
			for (double d : doubleList) {
				sum = sum + d;
				numCounter++;
			}

			// calculates the average
			average = sum / numCounter;

			// prints out the average
			System.out.println("The average of the " + numCounter + " numbers is: " + average);

		} catch (IOException e) {
			System.err.println("IOException in reading input file!!!");
		}
	} // end readFile()

	/**
	 * main : creates a Lab1b Object with the filename passed in argument
	 */
	public static void main(String args[]) {
		if (args.length == 0)
			System.err.println("enter the data file name!");
		else
			new Lab1b(args[0]);
		System.exit(0);
	} // end main

} // end class Lab1b
