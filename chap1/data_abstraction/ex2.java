/*
 * exercise 1.2.2
 *
 * write an Interval1D client that takes an int value n as command-line
 * argument, reads n intervals (each defined by a pair of double values) from
 * standard input, and prints all pairs that intersect.
*/

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ex2 
{
	public static void main(String[] args)
	{
		if (args.length != 1) {
			System.out.println("usage: java-algs4 ex2 [int n]");
			System.exit(1);
		}
		int n = Integer.parseInt(args[0]);

		Interval1D[] points = get_points(n);

		check_intersections(points);
	}


	// get points from stdin and store in an array
	private static Interval1D[] get_points(int n)
	{
		Interval1D[] points = new Interval1D[n];

		for (int i = 0; i < n; i++) {
			
			// read in two doubles from stdin
			StdOut.print("min: ");
			double min = StdIn.readDouble();
			StdOut.print("max: ");
			double max = StdIn.readDouble();
			
			if (min > max) {
				System.out.println("min must be smaller than max");
				i--;
				continue;
			}
			Interval1D tmp = new Interval1D(min, max);
			
			points[i] = tmp;	
		}
		return points;
	}

	
	// check if any of the points given intersect
	private static void check_intersections(Interval1D[] x)
	{
		System.out.println("\nintersecting points:\n");
		
		int count = 0;

		for (int i = 0; i < x.length; i++) {
			for (int j = i+1; j < x.length; j++) {
				if (x[i].intersects(x[j])) {
					StdOut.println(x[i]);
					count++;
				}
			}
		}
		if (count == 0) {
			System.out.println("[NONE]");
		}
	}
}
