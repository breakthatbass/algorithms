/*
 * exercise 1.3.7
 *
 * add a method peek() to Stack that returns the most recently inserted item on
 * the stack (without popping it)
 */


public class Stack<Item> {
	
	private Node head = null;
	private int size = 0;

	private class Node {
		Item item;
		Node next = null;
	}

	public boolean isEmpty() { return head == null; }

	public int size() { return size; }


	/* push: add a node to the front of the list */
	public void push(Item item) {
		Node tmp = head;
		
		head = new Node();
		head.item = item;
		head.next = tmp;

		size++;
	}


	/* pop: remove and return the front node */
	public Item pop() {
		if (isEmpty())
			return null;

		Node tmp = head;
		head = head.next;
		size--;

		return tmp.item;
	}

	// peek: answer to ex 1.3.7
	public Item peek() {
		if (size > 0)
			return head.item;
		else
			return null;
	}



	public static void main(String[] args)
	{
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);

		System.out.println("peeking: " + s.peek());
		System.out.println(s.pop());
		System.out.println("peeking: " + s.peek());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println("peeking: " + s.peek());
	}
}
