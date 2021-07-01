/*
 * Counter class for use with exercises in this section
 */
public class Counter 
{
	// instance variables
	private final String name;
	private int count = 0;

	// constructor
	// same as python's def __init__(self, name): function
	public Counter(String id) {
		name = id;
	}

	public void increment() {
		count++;
	}

	public int tally() {
		return count;
	}

	public String toString() {
		return count + " " + name;
	}
}

