/*
 * exercise 1.3.1
 *
 * add a method isFull() to FixedCapacityOfStrings
 */

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

	public String pop()
	{
		return a[--n];
	}

	public static void main(String[] args)
	{
		int n = 20;
		FixedCapStack s = new FixedCapStack(n);

		for (int i = 0; i < (n); i++) {
			s.push("hello");
		}
		System.out.println("Full: " + s.isFull());
	}
}
