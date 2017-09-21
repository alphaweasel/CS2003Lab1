package labOne;

import java.io.File;
import java.io.IOException;

/**
 * CS 2003 - Lab 1
 * Code to find the maximum integer in a given file
 * NOTE:
 * there are bugs including those causing compilation errors and
 * resulting in runtime logical problems
 *
 * @author Garrison Henkle
 * @since 8-31-17
 * @version 1.8
 */

import java.util.Scanner;
import java.util.Vector;

public class lab1a {

	/** stores the data retrieved from the file */
	Vector<Integer> intVector;
	/** variable used to compute the run-time */
	long startTime, endTime, totalTime;

	/**
	 * Constructor: computes the running time and call readFile method
	 */
	public void lab() {
		startTime = System.currentTimeMillis();
		readFile();
		endTime = System.currentTimeMillis();
		totalTime = endTime - startTime;
		System.out.println("total time taken: " + totalTime + " milliseconds");
	}

	/*
	 * Imports a file and stores the elements in the intVector, then finds the max
	 * of those elements
	 */
	public void readFile() {
		try {
			File inputFile = new File("Lab1a.dat");
			Scanner input = new Scanner(inputFile);
			intVector = new Vector<Integer>();
			int max = Integer.MIN_VALUE, elt, count = 0;
			// store all elements in a vector
			while (input.hasNextInt()) {
				elt = input.nextInt();
				count++;
				intVector.addElement(elt);
			}
			// print on the terminal each elements of intVector
			System.out.printf("There are %d integers in the input file:\n", count);
			for (int value : intVector)
				System.out.printf("%d ", value);
			System.out.println();

			// Find the max (I changed the i = 1 to i = 0 and set max to Integer.MIN_VALUE)
			for (int i = 0; i < intVector.size(); i++) {
				int value = intVector.get(i);
				if (max < value)
					max = value;
			}

			// output results
			System.out.printf("The maximum integer in the input file is %d\n", max);
			input.close();
		} catch (IOException e) {
			System.err.println("IOException in reading input file!!!");
		}
	} // end readFile()

	/** main : creates an Object Lab1a */
	public static void main(String args[]) {
		new lab1a();
	} // end main

} // end class Lab1a
