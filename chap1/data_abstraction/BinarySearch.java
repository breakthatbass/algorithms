/*
 * BinarySearch program for use with a few of the exercises in this section
 */

import java.util.Arrays;

public class BinarySearch 
{
	public int indexOf(int[] a, int key, Counter count)
	{
		// array must be sorted
		int lo = 0;
		int hi = a.length-1;

		while (lo <= hi) {
			count.increment();
			// key is in a[lo...hi] or not present
			int mid = lo+(hi-lo)/2;
			if (key < a[mid])
				hi = mid-1;
			else if (key > a[mid])
				lo = mid+1;
			else return mid;
		}
		return -1;
	}

/*
	public static void main(String[] args)
	{
		
	}
*/
}
