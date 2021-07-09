/*
 * exercise 1.3.1
 *
 * add a method isFull() to FixedCapacityOfStrings
 *
 *
 * exercise 1.3.2
 *
 * give the output printed bt the java Stack for the input
 * it was - the best - of times - - - it was - the - - -
 * 
 * usage: javac-algs4 FixedCapStack < test.txt
 *
 * output:
 * was best times of the was the it it (0 left on stack)
 */

import edu.princeton.cs.algs4.StdIn;

public class FixedCapStack
{
	private String[] a;
	private int n;

	// capacity not required: for error checking
	private int capacity;
	
	public FixedCapStack(int capacity)
	{
		this.capacity = capacity;
		a = new String[capacity];
	}

	public boolean isEmpty() { return n == 0; }
	public int size()		 { return n;  }

	/*** exercise 1.3.1 isFull() ***/
	public boolean isFull()	 { return n >= capacity; }

	public void push(String item)
	{
		// error checking to prevent overflow
		if ((n+1) > capacity) {
			System.out.println("stack is full with " + this.size() + " items");
			return;
		}
		a[n++] = item;
	}

	public String pop() { return a[--n]; }

	public static void main(String[] args)
	{
		int n = 20;
		FixedCapStack s = new FixedCapStack(n);

		for (int i = 0; i < (n); i++) {
			s.push("hello");
		}
		System.out.println("Full: " + s.isFull());

		
		/**** exercise 1.3.2  ****/

		FixedCapStack part2 = new FixedCapStack(n);

		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-"))
				part2.push(item);
			else if (!part2.isEmpty())
				System.out.print(part2.pop() + " ");
		}
		System.out.println("(" + part2.size() + " left on stack)");
	}
}
