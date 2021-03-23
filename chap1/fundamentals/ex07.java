import edu.princeton.cs.algs4.StdOut;

public class ex07
{
	public static void main(String args[])
	{
		a();  // 3.00009
		b();  // 499500
		c();  // 10000
	}

	public static void a()
	{
		double t = 9.0;
		while (Math.abs(t - 9.0/t) > 0.001)
			t = (9.0/t + t)/2.0;
		StdOut.printf("%.5f\n", t);
	}

	public static void b()
	{
		int sum = 0;
		for (int i = 0; i < 1000; i++)
			for (int j = 0; j < i; j ++)
				sum++;
		StdOut.println(sum);
	}

	public static void c()
	{
		int sum = 0;
		for (int i = 1; i < 1000; i *= 2)
			for (int j = 0; j < 1000; j++)
				sum++;
		StdOut.println(sum);
	}
}
