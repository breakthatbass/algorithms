/*
 * exercise 1.2.7
 *
 * what does the following recursive function return?
 *
 * is returns the reverse of a string
 */
public class ex7 
{
	public static void main(String[] args)
	{
		System.out.println(mystery("Hello World"));
		System.out.println(mystery("what will this string be??"));
	}

	public static String mystery(String s)
	{
		int n = s.length();
		if (n <= 1) return s;
		String a = s.substring(0, n/2);
		String b = s.substring(n/2, n);
		return mystery(b) + mystery(a);
	}
}
