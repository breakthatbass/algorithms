/*
 what does the following progrm print?

0
1
1
2
3
5
8
13
21
34
55
89
144
233
377
610

note: this program has the algs4 lib as a dependency.
more info here: https://algs4.cs.princeton.edu/mac/

compile with: javac-algs4 ex06.java
run with: java-algs4 ex06
 */
import edu.princeton.cs.algs4.StdOut;

public class ex06
{
	public static void main(String arg[])
	{
		int f = 0;
		int g = 1;
		for (int i = 0; i <= 15; i++) {
			StdOut.println(f);
			f = f + g;
			g = f - g;
		}
	}
}
