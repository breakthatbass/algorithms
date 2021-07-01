/*
 * exercise 1.2.10
 *
 * develop a class VisualCounter that allows both increment and decrement
 * operations.
 *
 * take two arguments `n` and `max` in the constructor, where `n` specifies the
 * maximum umber of operations and `max` specifies the maximum absolute value
 * for the counter.
 *
 * as a side effect, create a plot showing the value of the counter each time
 * its tally changes
 *
 * usage: java-algs4 VisualCounter n max
 * example: java-algs4 VisualCounter 500 1000
 */

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;


public class VisualCounter 
{
	// instace variables
	private int n;
	private int max;
	private int count = 0;
	private int operations = 0;


	// constructor method
	public VisualCounter(int n, int max) {
		// this keyword indicates instance vars, not the local vars
		this.n = n;
		this.max = max;

		// we'll also just do our StdDraw setting while we're here
		StdDraw.setCanvasSize(1024, 720);
		StdDraw.setPenRadius(0.005);
		StdDraw.setXscale(0, max);
		StdDraw.setYscale(0, max);
	}

	// methods
	public void increment() {
		if (operations == n || count == max) return;
		count++;
		operations++;

		// plot points and show
		StdDraw.point(operations, count);
		StdDraw.show();
	}

	public void decrement() {
		if (operations == n || count == 0) return;
		count--;
		operations++;

		// plot points and show
		StdDraw.point(operations, count);
		StdDraw.show();
	}

	public static void main(String[] args)
	{
		if (args.length != 2) {
			System.out.println("usage: java-algs4 VisualCounter n max");
			System.exit(1);
		}

		int n = Integer.parseInt(args[0]);
		int max = Integer.parseInt(args[0]);

		VisualCounter vc = new VisualCounter(n, max);

		for (int i = 0; i < n; i++) {
			int r = StdRandom.uniform(1,100);
			System.out.println(r);

			if (r % 2 == 0)
				vc.increment();
			else vc.decrement();
		}
	}
}
