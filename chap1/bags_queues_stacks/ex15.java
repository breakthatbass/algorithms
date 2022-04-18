/**
 * exercise 1.3.15
 *
 * write a queue client that takes a command-line argument k
 * and prints the kth from the last string found on standard input
 * (assuming that standard input has k or more strings)
 */

import edu.princeton.cs.algs4.Queue;

public class ex15
{
	public static void printk(Queue<String> q, int k)
	{
		int i = 0;
		for (String s: q) {
			i++;
			if (i == q.size() - (k-1)) {
				System.out.println(s);
			}
		}
	}
		
	public static void main(String[] args)
	{
		int k = Integer.parseInt(args[0]);

		// requires args to be "str1 str2 ..."
		String input = args[1];
		String[] _input = input.split(" ");

		Queue<String> q = new Queue<>();
		for (String s: _input) {
			q.enqueue(s);
		}

		printk(q, k);

	}
}
