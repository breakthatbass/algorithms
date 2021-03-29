/*
 * remove duplicates: modify the test client in BinarySearch to remove any
 * duplicate keys in the whitelist after the sort
*/

import java.util.Arrays;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

public class ex28 
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

	public static void remove_duplicates(int[] a)
	{
		int len = a.length;
		if (len == 0 || len == 1) return;

		int j = 0;
		int[] tmp = new int[len];
		for (int i = 0; i < len-1; i++) {
			if (a[i] != a[i+1])
				tmp[j++] = a[i];
		}
		tmp[j++] = a[len - 1];

		// change the original array
		for (int i = 0; i < len; i++)
			a[i] = tmp[i];
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

		int len = whitelist.length;
		remove_duplicates(whitelist);


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
