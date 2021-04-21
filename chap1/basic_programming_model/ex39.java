/*
 * random matches
 *
 * write a BinarySearch client that takes an int value trials as command-line
 * argument and runs the specified nnumber of trials of the following experiment
 * for n = 10(3), 10(4), 10(5), and 10(6): generate two arrays of n randomly
 * generated positive six-digit int values, and find the number of values that
 * appear in both arrays.
 *
 * for each value of n, print a table giving the average value of this quantity
 * over all trials.
*/

import java.lang.Math;
import java.util.Arrays;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ex39
{
	private static int bsearch(int key, int[] arr, int lo, int hi) {
		if (lo <= hi) {
			int mid = lo+(hi-lo)/2;
			
			if (key < arr[mid])
				return bsearch(key, arr, lo, mid-1);
			else if (key > arr[mid])
				return bsearch(key, arr, mid+1, hi);
			else
				return 1;
		}
		return 0;
	}

	private static int common_ints(int size)
	{
		int i, total;
		int[] a1 = new int[size];
		int[] a2 = new int[size];
		total = 0; // initialize for compiler happiness

		// fill with random 6-digit numbers
		for (i = 0; i < size; i++) {
			a1[i] = StdRandom.uniform(100000, 1000000);
			a2[i] = StdRandom.uniform(100000, 1000000);
		}
		// find the number of values that are in both arrays
		for (i = 0; i < size; i++)
			total += bsearch(a1[i], a2, 0, size-1);
		return total;
	}

	public static void main(String[] args)
	{
		int trials = Integer.parseInt(args[0]);

		int n1 = (int) Math.pow(10, 3);
		int n2 = (int) Math.pow(10, 4);
		int n3 = (int) Math.pow(10, 5);
		int n4 = (int) Math.pow(10, 6);

		int[] results = new int[4];
		for (int i = 0; i < trials; i++) {
			results[0] += common_ints(n1);
			results[1] += common_ints(n2);
			results[2] += common_ints(n3);
			results[3] += common_ints(n4);
		}
		
		StdOut.printf("%10s %37s\n", "array size", "avg # of values in both arrays");
		StdOut.printf("10ˆ3 %17.2f \n", ((double)results[0])/trials);
		StdOut.printf("10ˆ4 %17.2f \n", ((double)results[1])/trials);
		StdOut.printf("10ˆ5 %17.2f \n", ((double)results[2])/trials);
		StdOut.printf("10ˆ6 %17.2f \n", ((double)results[3])/trials);
	}
}
