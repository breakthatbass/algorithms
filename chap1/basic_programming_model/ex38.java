/*
 * binary search versus brute-force search
 *
 * write a program BruteForceSearch that uses the brute-force search method
 * given on page 48 and compare it's running time on your computer with that of
 * BinarySearch for largeW.txt and largeT.txt
 *
 * for both largeW.txt and largeT.txt brute force is something like 200x slower
 *
 * compile: javac-algs4 ex38.java
 * run: java-algs4 ex38 largeT.txt
*/

import java.util.Arrays;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

public class ex38 
{

	public static int BruteForceSearch(int[] a, int key)
	{
		for (int i = 0; i < a.length; i++)
			if (a[i] == key) return i;
		return -1;
	}

	public static int BinarySearch(int[] a, int key)
	{
		int lo = 0;
		int hi = a.length-1;
		while (lo <= hi) {
			int mid = lo + (hi-lo)/2;
			if (key < a[mid]) hi = mid-1;
			else if (key > a[mid]) lo = mid+1;
			else return mid;
		}
		return -1;
	}


	public static void main(String[] args)
	{
		In in = new In(args[0]);
		int[] a = in.readAllInts();
		Arrays.sort(a);

		// we'll just search for one item and time it
		int key = 760788;

		// BRUTEFORCE TIMING
		long start_time = System.nanoTime();
		System.out.println("bruteforce -> " + BruteForceSearch(a, key));
		long end_time = System.nanoTime();
		long total_time = end_time-start_time;

		System.out.println("total time (nanoseconds): " + total_time);

		System.out.println();

		// BINARY SEARCH TIMING
		start_time = System.nanoTime();
		System.out.println("binary search -> " + BinarySearch(a, key));
		end_time = System.nanoTime();
		total_time = end_time-start_time;

		System.out.println("total time (nanoseconds): " + total_time);
	}
}
