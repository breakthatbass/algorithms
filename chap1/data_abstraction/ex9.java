/*
 * exercise 1.2.9
 *
 * instrument BinarySearch (page 47) to use a Counter to count the total number
 * of keys examined during all searches and then print the total after all
 * searches are complete.
 *
 * hint: create a Counter in main() and pass it as an argument to indexOf().
 *
 * note:
 * 
 * see BinarySearch.java in this directory for the BinarySearch class
 * implementation
 *
 * see Counter.java in this directory for the Counter class implementation
 */

import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ex9 
{
	public static void main(String[] args)
	{
		// see BinarySearch.java for implementation
		BinarySearch bs = new BinarySearch();

		// see Counter.java for implentation
		Counter count = new Counter("count");

		In in = new In(args[0]);
		int[] whitelist = in.readAllInts();
		Arrays.sort(whitelist);

		while (!StdIn.isEmpty()) {
			// read key, print if not in whitelist
			int key = StdIn.readInt();
			if (bs.indexOf(whitelist, key, count) == -1)
				StdOut.println(key);
		}

		StdOut.println("total: " + count.tally());
	}
}
