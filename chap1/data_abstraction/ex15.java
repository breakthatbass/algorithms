/*
 * exercise 1.2.15
 *
 * File Input. Develop a static version of the readAllInts() method from In
 * (which we use for various test clients, such as binary search on page 47)
 * that is based on the split() method in String.
 */
import edu.princeton.cs.algs4.In;

public class ex15
{
	public static int[] readAllInts(String name)
	{
		In in = new In(name);
		String input = in.readAll();
		String[] words = input.split("\\s+");
		
		int[] ints = new int[words.length];
		
		for (int i = 0; i < words.length; i++) {
			ints[i] = Integer.parseInt(words[i]);
		}

		return ints;
	}


	public static void main(String[] args)
	{
		int[] p = readAllInts("tinyT.txt");

		for (int i = 0; i < p.length; i++)
			System.out.println(p[i]);

	}
}
