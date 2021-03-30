/*
 * array exercise:
 * write a code fragment that creates an n-by-n boolean array a[][] such that
 * a[i][j] is true if i and j are relatively prime (have no common factors), and
 * false otherwise
 *
 * two integers are considered 'relatively prime' or 'coprime' if the gcd of
 * both numbers is 1.
*/

public class ex30 
{
	public static int NUMS = 100;

	public static int gcd(int p, int q)
	{
		if (q == 0) return p;
		int r = p % q;
		return gcd(q, r);
	}

	public static void main(String[] args)
	{
		// allocating memory for an array using a global like this is
		// how it is typically done in C. I'm not sure what the Java convention is
		// either way, this will work
		boolean[][] a = new boolean[NUMS][NUMS];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (gcd(i, j) == 1) a[i][j] = true;
				else a[i][j] = false;
			}
		}

		// print the values
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.println(a[i][j]);
			}
		}
	}
}
