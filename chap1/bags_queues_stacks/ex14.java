/*
 * exercise 1.3.14
 *
 * Develop a class ResizingArrayQueueOfStrings that implements 
 * the queue abstraction with a fixed-size array, and then extend
 * your implementation to use array resizing to remove the size restriction.
 *
 */
public class ex14
{
	private String[] items;
	private int first;
	private int last;
	private int len;

	public ex14(int size) { items = new String[size];  }

	public boolean isEmpty() { return len == 0; }
	public int size() { return len; }

	public void print() {
		for (int i = first; items[i] != null; i++) {
			System.out.println(items[i]);
		}
	}

	public void resize(int size) {
		// size should be larger than original size
		String[] tmp = new String[size];
		int j = first;
		for (int i = 0; i < last; i++) {
			if (j <= len) tmp[i] = items[j++];
		}
		items = tmp;
		first = 0;
		last = len;
	}

	public void enqueue(String s) {
		if (len == items.length) resize(items.length*2);
		
		items[last++] = s;
		len++;
	}

	public String dequeue() {
		if (isEmpty()) {
			System.out.println("empty");
			return null;
		}

		String s = items[first];
		items[first] = null;
		first++;
		if (first == items.length) first = 0;
		len--;
		return s;
	}

	public static void main(String[] args)
	{
		ex14 s = new ex14(3);

		s.enqueue("foo");
		s.enqueue("bar");
		s.enqueue("baz");
		s.enqueue("biz");
		s.enqueue("buzz");
		s.print();
		System.out.println();
		System.out.println(s.dequeue());
		System.out.println(s.dequeue());
		System.out.println();

		System.out.println(s.size());
		s.print();

	}
}
