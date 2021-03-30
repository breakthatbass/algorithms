/*
 * random connections:
 * write a program that takes as command-line arguments an integer n and a
 * double value p (between 0 and 1), plots n equally spaced dots of size 0.05 on
 * the circumference of a circle, and then, with probability p for each pair of
 * points, draws a gray line connecting them
 *
 * i really had no clue how to mathematically make this work
 * i found this resource: https://superuser.com/questions/477819/how-to-open-a-particular-file-from-a-terminal
 * which i basically copied everything i didn't know how to do.
 *
 * coming from C using object oriented programming in this way was a bit weird
 * to me but it's not much different than a struct with methods that take
 * advantage of the struct.
 *
 * here we have the class Point which has two doubles, and the Point() function
 * just creates an instance of the Point class which we use in the loop and add
 * that instance into the Point array...which is an array of instances of the
 * class Point. Not totally that different from an array of structs in C. Each
 * instance holds an x and y coordinate.
*/

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class ex31 
{
	static class Point {
		double x;
		double y;
	

		public Point(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args)
	{
		if (args.length != 2) {
			StdOut.printf("usage: java ex31 <int> <double(between 0 and 1)>\n");
			System.exit(1);
		}
		
		int n = Integer.parseInt(args[0]);
		double p = Double.parseDouble(args[1]);

		double angle = 360.0 / n;

		// check that double is between 0 and 1
		if (p < 0 || p > 1) {
			StdOut.printf("double must be between 0 and 1\n");
			System.exit(1);
		}
		StdOut.printf("n: %d p: %f\n", n, p);

		StdDraw.circle(0.5, 0.5, 0.5); // 0.5, 0.5, 0.5 centers the circle in the window
		
		// create an array that will hold instances of the class Point
		Point[] points = new Point[n];

		for (int i = 0; i < n; i++) {
			// make a new instance of the Point class and store it in the array
			points[i] = new Point(
				0.5+0.5*Math.cos(angle*i*Math.PI/180),
				0.5+0.5*Math.sin(angle*i*Math.PI/180));
			// plot the points around the circumference of the circle
			StdDraw.point(points[i].x, points[i].y);
		}
		// connect the points
		StdDraw.setPenColor(StdDraw.CYAN);
		for (int i = 0; i < n-1; i++) {
			for (int j= i+1; j < n; j++) {
				// what is bournoulli? no clue. i copied it.
				if (StdRandom.bernoulli(p)) {
					StdDraw.line(points[i].x, points[i].y, points[j].x, points[j].y);
				}
			}
		}
	}
}
