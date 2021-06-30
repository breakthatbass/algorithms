/*
 * a string is a `circular shift` (or ciircular rotation) of a string t if it
 * matches when the characters are circularly shifted by any other number of
 * positions;
 * 
 * e.g., ACTGACG is a circular shift of TGACGAC , and vice versa.
 * 
 * detecting this condition is important int he study of genomic sequences.
 *
 * write a program that checks whether two given strings s and t are circular
 * shifts of one another.
 *
 * hint: the solution is a one-liner with indexOf(), length(), and string
 * concatenation.
 *
 * my solution is a bit simpler and probably doesn't always work correctly.
*/
public class ex6
{
	public static void main(String[] args)
	{
		if (args.length != 2) {
			System.out.println("usage: java ex6 str1 str2");
			System.exit(1);
		}

		System.out.println(check_shift(args[0], args[1]));
	}

	private static boolean check_shift(String s, String t)
	{
		String tmp = s+s;
		return tmp.contains(t);
	}
}
