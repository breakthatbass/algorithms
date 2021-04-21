/*
 * bad shuffling
 *
 * suppose that you chose a random integer between 0 and n-1 in pur shuffling
 * code instead of one betwwn i and n-1.
 *
 * show that the resulting order is not euqally likely to be one of the n!
 * possibilities. run the test of the previous exercise for this version.
 *
*/

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ex37 
{
	private static void init_arr(int[] a)
	{
		for (int i = 0; i < a.length; i++)
			a[i] = i;
	}

	private static void shuffle(int[] a)
	{
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int r = StdRandom.uniform(n);
			int tmp = a[i];
			a[i] = a[r];
			a[r] = tmp;
		}
	}

	public static void print_tab(int[][] table)
	{
		StdOut.println("table of shuffles:");

		for (int i = 0; i < table.length; i++) {
			StdOut.printf("%3d ", i);
			for (int j = 0; j < table[0].length; j++) {
				StdOut.printf("%4d ", table[i][j]);
			}
			StdOut.println();
		}
	}


	private static void shuffle_test(int m, int n)
	{
		int [][] table = new int[m][n];
		int[] a = new int[m];

		for (int i = 0; i < n; i++) {
			init_arr(a);
			shuffle(a);
			for (int j = 0; j < a.length; j++) {
				table[a[j]][j]++;
			}
		}

		print_tab(table);
	}


	public static void main(String[] args)
	{
		int n = Integer.parseInt(args[0]);
		int m = Integer.parseInt(args[1]);

		shuffle_test(m, n);
	}
}
