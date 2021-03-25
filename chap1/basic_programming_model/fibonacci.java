/*
 * run the following program on your computer
 *
 * what is the largest value of n for which this program takes less than 1 hour
 * to compute the value of fib(n)? develop a better implementation of fib(n)
 * that saves computed values in an array
 *
 * there are 3,600 seconds in an hour
 * and each loop increases in time by about 1.62 times the previous loop's time
 *	most likely the largest value of n that can be computed in under an hour is
 *	59 which gets 2298 seconds or so for time. it's a little over 38 minutes.
 *
 *
 * my fast_fib() function makes use of memoization which basically just keeps a cache
 * of previously computed numbers. the traditonal fibonacci algorithm is so slow
 * because with each iteration it has to re-compute all the previous
 * computations it has already done. the fib_cache array simply holds each
 * computation and it pulls from that rather than computing again.
 *
 */

public class fibonacci
{
	public static int FIBMAX = 90;
	public static long[] fib_cache;

	public static long fib(int n)
	{
		if (n == 0) return 0;
		if (n == 1) return 1;
		return fib(n-1) + fib(n-2);
	}

	public static long fast_fib(int n)
	{
		long val;
		// if we have the cached value, return it
		if (fib_cache[n] != 0) return fib_cache[n];

		// compute the nth term
		if (n == 0) val = 0;
		else if (n == 1) val = 1;
		else val = fast_fib(n-1) + fast_fib(n-2);

		// cache the val and return it
		fib_cache[n] = val;
		return val;
	}


	public static void main(String[] args)
	{
		fib_cache = new long[FIBMAX];

		for (int n = 0; n < FIBMAX; n++) {
			System.out.println(n + ": " + fast_fib(n));
		}
	}

}
