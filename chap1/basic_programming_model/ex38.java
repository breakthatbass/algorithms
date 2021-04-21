/*
 * binary search versus brute-force search
 *
 * write a program BruteForceSearch that uses the brute-force search method
 * given on page 48 and compare it's running time on your computer with that of
 * BinarySearch for large
*/

import java.util.Arrays;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

public class ex38 
{

	public static int indexOf(int[] a, int key)
	{
		for (int i = 0; i < a.length; i++)
			if (a[i] == key) return i;
		return -1;
	}


	public static void main(String[] args)
	{
		In in = new In(args[0]);
		int[] whitelist = in.readAllInts();
		Arrays.sort(whitelist);

		while (!StdIn.isEmpty()) {
			// read key, print if not in whitelist
			int key = StdIn.readInt();
			if (indexOf(whitelist, key) == -1)
				StdOut.println(key);
		}
	}
}
