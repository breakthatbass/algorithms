/*
 * write a static method histogram() that takes an array a[] of int values and
 * an integer m as arguments and returns an array of length m whose ith entry
 * is the number of times the integer i appeared in the argument array. if the
 * values in a[] are all between 0 and m-1, the sum of the values in the
 * returned array should be equal to a.length
 */

public class histogram
{
	public static void main(String[] args)
	{
		int[] a = {1, 1, 5, 1, 3, 5, 2, 2, 6};
		int[] b = histogram(a, a.length-1);

		for (int i = 0; i < b.length; i++)
			System.out.print(b[i] + " ");
		System.out.println();
	}

	public static int[] histogram(int[] a, int m)
	{
		int i;
		int[] n = new int[m];

		for (i = 0; i < m; i++) {
			for (int j = 0; j < a.length; j++) {
				if (a[j] == i) n[i]++;
			}
		}

		return n;
	}
}
