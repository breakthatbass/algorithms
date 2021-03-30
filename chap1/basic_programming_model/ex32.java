/*
 * histogram:
 * suppose that the standard input stream  is a sequence of double values.
 * write a program that takes an integer n and two double values lo and hi from
 * the command line and uses StdDraw to plot a histogram of the count of the
 * numbers in the standard input stream that fall in each of the n intervals
 * defined by dividing (lo, hi) into n equal-sized intervals.
 *
 * I mostly copied from: https://github.com/aistrate/AlgorithmsSedgewick/blob/master/1-Fundamentals/1-1-BasicProgModel/Ex_1_1_32.java
*/

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.In;

public class ex32 
{
	public static void histogram(double[] a, int n, double lo, double hi)
	{
		int [] counts = new int[n];
		for (int i = 0; i < a.length; i++) {
			int k = get_interval(a[i], n, lo, hi);
			if (k >= 0) counts[k]++;
		}

		//StdDraw.setCanvasSize(1024, 512);
		StdDraw.setXscale(lo, hi);
		StdDraw.setYscale(0, StdStats.max(counts));

		double w = (hi-lo)/n;

		for (int i= 0; i < n; i++) {
			double x = lo + (i+0.5)*w;
			double y = counts[i]/2.0;
			double rw = 0.5*w;
			double rh = counts[i]/2.0;
			StdDraw.filledRectangle(x, y, rw, rh);
		}
	}

	public static int get_interval(double v, int n, double lo, double hi)
	{
		if (v < lo || v >= hi) return -1;
		else return (int)(n*(v-lo)/(hi-lo));
	}

	public static void main(String[] args)
	{
		// check for 3 args
		if (args.length != 3) {
			System.out.println("usage: java-algs4 ex32 <int> <lo> <hi> < file");
			System.exit(1);
		}
		
		int n = Integer.parseInt(args[0]);
		double lo = Double.parseDouble(args[1]);
		double hi = Double.parseDouble(args[2]);

		System.out.printf("n: %d lo: %f hi: %f\n", n, lo, hi);
		// read in from text
		double[] v = In.readDoubles();
		for (int i = 0; i < v.length; i++)
			System.out.println(i + ": " + v[i]);

		histogram(v, n, lo, hi);
	}
}
