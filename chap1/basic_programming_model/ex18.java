/* consider the following recursive function...
 *
 * what are the values of mystery(2, 25) and mystery(3, 11)? given positive
 * integers a and b, describe what value mystery(a, b) computes. answer the same
 * question, but replace the three '+' operators with '*' and replace return 0
 * with return 1
 *
 * the first one seems to multiply the two integers
 *
 * the second one raises a to b power. a is the number and b is the exponent.
 */

public class ex18
{
	public static void main(String[] args)
	{
		int a = mystery1(2, 25);	// 50
		int b = mystery1(3, 11);	// 33

		System.out.println(a);
		System.out.println(b);

		int c = mystery2(2, 25);	// 33554432
		int d = mystery2(3, 11);i	// 177147
		System.out.println(c);
		System.out.println(d);
	}

	private static int mystery1(int a, int b)
	{
		if (b == 0) return 0;
		if (b % 2 == 0) return mystery1(a+a, b/2);
		return mystery1(a+a, b/2) + a;
	}

	private static int mystery2(int a, int b)
	{
		if (b == 0) return 1;
		if (b % 2 == 0) return mystery2(a*a, b/2);
		return mystery2(a*a, b/2) * a;
	}
}
