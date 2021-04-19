/*
 * random connections:
 * write a program that takes as command-line arguments an integer n and a
 * double value p (between 0 and 1), plots n eqully space dots of size 0.05 on
 * the circumference of a circle, and then, with probability p for each pair of
 * points, draws a gray line connecting them.
*/

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class ex31 
{
	public static void main(String[] args)
	{
		StdDraw.setCanvasSize(900, 900);
		StdDraw.setScale(-1.0, 1.0);
		StdDraw.setPenRadius(.015);

		for (int i = 0; i < 100; i++) {
			StdDraw.point(i, i);
			StdDraw.point(i, i*i);
			StdDraw.line(0, 1, 2, 3);
		}
	}
}
