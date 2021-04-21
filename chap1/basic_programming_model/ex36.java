/*
 * empiracle shuffle deck
 *
 * run computational experiments to check that our shuffling code on page 32
 * works as advertised.
 *
 * write a program called ShuffleTest that takes command-line argumanets m and
 * n, does n shuffles of an array of length m that is initialized with a[i] = i
 * before each shuffle, and prints an m-by-m table such that row i gives the
 * nu,bers of time i wound up in position j for all j. all entries in the table
 * should be close to n/m.
 *
*/
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ex36 
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
			int r = i + StdRandom.uniform(n-i);
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
