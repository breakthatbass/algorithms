/*
 * exercise 1.3.6
 *
 * what does the following code do to the queue q?
 *
 * it inverts it.
 */

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class ex06
{
	private static void thing(Queue<String> q)
	{
		Stack<String> s = new Stack<String>();
		while (!q.isEmpty())
			s.push(q.dequeue());
		while (!s.isEmpty())
			q.enqueue(s.pop());
	}


	public static void main(String[] args)
	{
		Queue<String> q = new Queue<String>();
		q.enqueue("foo");
		q.enqueue("bar");
		q.enqueue("baz");

		thing(q);

		for (String s : q) System.out.println(s);
		/*
		 * prints:
		 * baz
		 * bar
		 * foo
		 */
	}
}
