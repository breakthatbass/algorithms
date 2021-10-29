/*
 * exercise 1.3.7
 *
 * add a method peek() to Stack that returns the most recently inserted item on
 * the stack (without popping it)
 *
 * exercise 1.3.12
 * 
 * write an iterable stack client that has the static method copy() that
 * takes a stack of strings as an argument and returns a copy of the stack.
 * note: this ability is a prime example of the value of having an iterator,
 * because it allows development of such functionality without changing the
 * basic API.
 */

import java.util.Iterator;


public class Stack<Item> implements Iterable<Item> {
	
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

	
	// iterator
	public Iterator<Item> iterator() {
		return new StackIterator();
	}

	private class StackIterator implements Iterator<Item> {
		private Node current = head;
		
		public Item next() {
			Item tmp = current.item;
			current = current.next;
			return tmp;
		}

		public boolean hasNext() { return current != null; }
	}
	// iterator end
	
	public String toString() {
		String s = "[";
		int limit = this.size;
		int i = 1;

		for (Item d: this) {
			s += d;
			if (i < limit) s += ", ";
			i++;
		}
		s += "]";
		return s;
	}

	// exercise 1.3.12
	public static Stack<String> copy(Stack<String> s) {
		// two stacks because copying to one makes it backwards
		// definitely not the best solution but i dont know
		// that adding append() was what the book wants either

		Stack<String> newstack = new Stack<>();
		Stack<String> tmp = new Stack<>();

		for (String el: s) {
			tmp.push(el);
		}

		for (String el: tmp) {
			newstack.push(el);
		}
		return newstack;
	}




	public static void main(String[] args)
	{
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		
		System.out.println("peeking: " + s.peek());
		
		for (int d : s) System.out.println(d);
		System.out.println(s);

		// ex 12
		Stack<String> to_copy = new Stack<String>();
		to_copy.push("hello");
		to_copy.push("how");
		to_copy.push("are");
		to_copy.push("you");

		System.out.println(to_copy);
		System.out.println(to_copy.copy(to_copy));
	}
}
