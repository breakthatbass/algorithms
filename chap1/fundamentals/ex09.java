/*
 * write a code fragment that puts the binary representation of a positive
 * integer n into a string s
 */

public class ex09
{
	public static void main(String args[])
	{
		assert args.length == 1;

		int n = Integer.parseInt(args[0]);
		String s = "";

		for (int k = n; k > 0; k /= 2)
			s = (k%2)+s;
		System.out.println(s);
	}
}
