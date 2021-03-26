/*
 * write a recursive static method that computes the value of ln(n!)
 *
 * i had to look up what ln even is.
 * the method log(double a) returns the natural logarithm of a, or ln a.
 *
 */



public class ex20
{
	public static double ln(int n)
	{
		if (n == 1) return 0;
		return Math.log(n) + ln(n-1);
	}

	public static void main(String[] args)
	{
		int a = 10;
		System.out.println(ln(a));
	}
}
