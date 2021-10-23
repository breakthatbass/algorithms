/*
 * exercise 1.3.8
 *
 * give the contents and size of the array for ResizingArrayStackOfStrings
 * with the input
 *		it was - the best - of times - - - it was - the - -
 */

import edu.princeton.cs.algs4.StdIn;


public class ResizeArrayStack 
{
	public static void main(String[] args)
	{
		Stack<String> s = new Stack<String>();

		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			
			if (!item.equals("-"))
				s.push(item);
		}

		System.out.println("\nsize: " + s.size());
		System.out.println("\ncontents: " + s.toString());
		for (String t : s) System.out.println(t); 
	}
}
