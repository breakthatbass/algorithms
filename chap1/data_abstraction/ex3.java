/*
 * exercise 1.2.3
 *
 * write an Interval2D client that takes command-line arguments n, min, and max
 * and generates n random 2D intervals whose width and height are uniformly
 * distributed between min and max in the unit square. draw them on StdDraw and
 * print the number of pairs of intervals that intersect and the number of
 * intervals that are contained in one another
 *
 * due to lack of time i skipped the last steps of printing the intersecting
 * paris and the intervals that are contained in one another.
 *
 * if you want to add that, please do it!
 */
import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdDraw;

public class ex3 
{
	public static void main(String[] args)
	{
		// command-line args: n, min, max
		int n;
		double min, max;

		if (args.length != 3) {
			System.out.println("usage: java ex3 n min man");
			System.exit(1);
		}

		n = Integer.parseInt(args[0]);
		min = Double.parseDouble(args[1]);
		max = Double.parseDouble(args[2]);

		Interval2D[] p = plot_points(n, min, max);
	}


	private static Interval2D[] plot_points(int n, double min, double max)
	{
		Interval2D[] points = new Interval2D[n];
		double x, y, a, b;

		// StdDraw settings
		StdDraw.setCanvasSize(1024, 720);
		StdDraw.setPenRadius(0.005);
		StdDraw.setXscale(min, max);
		StdDraw.setYscale(min, max);

		for (int i = 0; i < n; i++) {
			// create two Interval1D intervals with random mins and maxes
			x = StdRandom.uniform(min, max);
			y = StdRandom.uniform(min, max);

			// min always has to be smaller than max
			// if min is larger, switch them
			if (x > y) {
				double tmp = x;
				x = y;
				y = tmp;
			}

			a = StdRandom.uniform(min, max);
			b = StdRandom.uniform(min, max);
			if (a > b) {
				double tmp = a;
				a = b;
				b = tmp;
			}

			Interval1D tmp1 = new Interval1D(x, y);
			Interval1D tmp2 = new Interval1D(a, b);

			Interval2D tmp  = new Interval2D(tmp1, tmp2);

			tmp.draw();
			points[i] = tmp;
		}
		return points;
	}
}
