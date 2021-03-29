/*
 * equal keys:
 * add to BinarySearch a static method rank() that takes a sorted array of int
 * values (some of which may be equal) and a key as arguments and returns the
 * number of elements that are smaller than the key and a similar method count()
 * that returns the number of elements equal to the key.
 *
 * note: if i and j and the values returned by rank(a, key) and count(a, key)
 * respectively, then a[i...i+j-1] are the values in the array that are equal to
 * the key.
 */

import java.util.Arrays;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

public class ex29
{
	public static int rank(int[] a, int key)
	{
		int count = 0;
		int len = a.length;
		for (int i = 0; i < len; i++)
			if (a[i] < key) count++;
		return count;
	}

	public static int count(int[] a, int key)
	{
		int count = 0;
		int len = a.length;
		for (int i =0; i < len; i++)
			if (a[i] == key) count++;
		return count;
	}

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

		int a = rank(whitelist, 75);
		int b = count(whitelist, 13);
		System.out.println("rank: " + a + "\ncount: " + b);

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
