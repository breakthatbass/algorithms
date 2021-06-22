/*
 * exercise 1.2.1
 *
 * write a Point2D client that takes an integer value n from the command line,
 * generates n random points in the unit square, and computes the distance
 * seperating the closest pair of points
 *
*/

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class ex1 
{
	public static void main(String[] args)
	{
		int n = Integer.parseInt(args[0]);

		// create an array to store all the points
		Point2D[] p = plot_points(n);

		//plot_points(p);

		double shortest = find_closest(p);
		System.out.println("shortest distance: " + shortest);
	}

	private static Point2D[] plot_points(int n) {

		Point2D[] p = new Point2D[n];

		for (int i = 0; i < n; i++) {
			double x = StdRandom.uniform();
			double y = StdRandom.uniform();
			/*
			System.out.println("x: " + x);
			System.out.println("y: " + y);
			*/
			Point2D point = new Point2D(x, y);
			p[i] = point;
		}
		return p;
	}


	public static double find_closest(Point2D[] p) {
		double shortest = 1.0;  // points are always below 1
		double current;

		for (int i = 0; i < p.length-1; i++) {
			for (int j = i+1; j < p.length; j++) {
				current = p[i].distanceTo(p[j]);

				if (current < shortest) shortest = current;
			}
		}
		return shortest;
	}
}
