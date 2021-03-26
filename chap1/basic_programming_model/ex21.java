/*
 * write a program that reads lines from standard input with each line
 * containing a name and two integers and then uses printf() to print a table
 * with a column of the names, the integers, and the result of dividing the
 * first by the second, accurate to three decimal places.
 *
 * you could use a program like this to tabulate batting averages for baseball
 * players or grades for students.
 *
 * the book provides a lib for this to make it easier but i wanted to learn how
 * to do these exercises with the built in tools of the java language
 */

import java.util.Scanner;

public class ex21
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);	// this allows us to use scan to read from stdin
		String name = "";
		String int1 = "";
		String int2 = "";
		float[] ints = null;
		
		// get name and keep asking for it until a name is provided
		while (name.length() == 0) {
			System.out.print("name: ");
			name = scan.nextLine();
		}

		// keep attempting to get input until two strings are provided
		while (ints == null) {
			System.out.print("integer 1: ");
			if (scan.hasNextLine()) int1 = scan.nextLine();
			else continue;
			
			System.out.print("integer 2: ");
			if (scan.hasNextLine()) int2 = scan.nextLine();
			else continue;

			// if we make it here, two integers were provided
			// ideally we should check that the strings provided are indeed integers
			// but i'm instead just going to assume they will be
			// this wouldn't be okay in an actual piece of software
			ints = new float[2];
			ints[0] = Integer.parseInt(int1);
			ints[1] = Integer.parseInt(int2);
		}
	// print it all out in a hacky table
	System.out.printf("name:\t\taverage:\n%s\t\t%.3f\n", name, ints[0]/ints[1]);	
	}
}
