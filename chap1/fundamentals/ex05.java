/*
 * write a code fragment that prints 'true' if the double variables x and y
 * are both strictly between 0 and 1 and 'false' otherwise.
 *
 */
public class ex05
{
	public static void main(String args[])
	{
		between(0.3, 0.9);  // true
		between(0.1, 1.33); // false
	}

	public static void between(double a, double b)
	{
		if (a > 0 && a < 1 && b > 0 && b < 1) System.out.println("true");
		else System.out.println("false");
	}
}
