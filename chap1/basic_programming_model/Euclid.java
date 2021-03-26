/*
 * give teh sequence of values of p and q that are computed when euclid's
 * algorithm is used to compute the greatest common divisor of 105 and 24.
 * 
 * extend the code given on page 4 to develop a program Euclid that takes two
 * integers from the command line and computes their great common divisor,
 * printing out the two arguments for each call on the recursive method. 
 *
 * use your program to compute the greatest common divisor of 1111111 and 1234567...it is 1.
 *
 */

public class Euclid
{
	public static int gcd(int p, int q)
	{
		System.out.println(p + "\t" + q);
		if (q == 0) return p;
		int r = p % q;
		return gcd(q, r);
	}

	public static void main(String[] args)
	{
		if (args.length != 2) {
			System.out.println("usage: java Euclid <p> <q>");
			System.exit(1);
		}

		int arg1 = Integer.parseInt(args[0]);
		int arg2 = Integer.parseInt(args[1]);

		int euc = gcd(arg1, arg2);
		System.out.println("gcd: " + euc);
	}
}
