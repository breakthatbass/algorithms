/*
 * write a version of BinarySearch that uses the recursive indexOf() given on
 * page 25 and traces he method calls.
 *
 * each time the recursive method is called, print the argument values lo and
 * hi, indented by the depth of the recursion.
 *
 * hint: add an argument to the recursive method that keeps track of the depth.
 *
 * I added the 'steps' argument and with each recursive call just did 'steps+1'
 * calling the function in main, i just start steps at 0.
 */

public class recursive_bsearch
{
	// with binary search we assume the array is sorted already
	public static int indexOf(int[] a, int key, int lo, int hi, int steps)
	{
		if (lo > hi) return -1;

		// print the indents
		for (int i = 0; i < steps; i++)
			System.out.print(" ");
		// now print the lo and hi
		System.out.println("lo: " + lo + " hi: " + hi);

		int mid = lo + (hi - lo)/2;

		if (key < a[mid]) return indexOf(a, key, lo, mid-1, steps+1);
		else if (key > a[mid]) return indexOf(a, key, mid+1, hi, steps+1);
		else return mid;
	}

	public static void main(String[] args)
	{
		if (args.length != 1) {
			System.out.println("usage: java bsearch <num-to-search>");
			System.exit(1);
		}
		// big array to see a lot of steps.
		int a[] = new int[100];
		for (int i = 1; i <= 100; i++)
			a[i-1] = i;

		int arg = Integer.parseInt(args[0]);

		int n = indexOf(a, arg, a[0], a[a.length-1], 0);
		System.out.println(n);
	}
}
