/*
 * add to the BinarySearch test client the ability to respond to a second
 * argument: + to the print the numbers from standard inpit that are not in the
 * whitelist, - to print numbers that are in the whitelist
 *
 * compile with	javac-algs4 testclient_bsearch.java
 * run with			java-algs4 testclient_besearch tinyW.text < tinyT.txt +/-
 */

import java.util.Arrays;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

public class testclient_bsearch
{
	public static int indexOf(int[] a, int key)
	{
		// array must be sorted
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
		if (args.length != 2) {
			StdOut.println("usage: java-algs4 testclient_bsearch tinyW.txt < tinyT.txt +/-");
			System.exit(1);
		}

		In in = new In(args[0]);
		int [] whitelist = in.readAllInts();
		Arrays.sort(whitelist);

		while (!StdIn.isEmpty()) {
			// read key, print if not in whitelist
			int key = StdIn.readInt();
			if (indexOf(whitelist, key) == -1 && args[1].equals("-"))
				StdOut.println(key);
			else if (indexOf(whitelist, key) != -1 && args[1].equals("+"))
				StdOut.println(key);
		}
	}
}
