/*
 * write a static method lg() that takes an int value n as argument and returns
 * the largest int not larger than the base-2 logarythm of n. do not use Math.
 */

public class ex14
{
	public static void main(String args[])
	{
		assert args.length == 1;

		int arg = Integer.parseInt(args[0]);
		int n = lg(arg);
		System.out.println(n);
	}

	public static int lg(int n)
	{
		int m = 0;
		int ex = 2;
		while (ex <= n) {
			m++;
			ex *= 2;
		}
		return m;
	}
}
