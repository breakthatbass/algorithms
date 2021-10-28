/*
 * exercise 1.3.9 
 *
 * write a program that from standard input an expression
 * without left parentheses and prints the equivalent infix expression
 * with the parentheses inserted.
 *
 * for example, given the input:
 *
 *	1 + 2 ) * 3 - 4) * 5 - 6)))
 *
 * your program should print:
 *
 *	((1 + 2) * ((3 - 4) * (5 - 6)))
 *
 *	----------
 *	created by: taylor gamache
 *	date: 10/28/21
 */

import edu.princeton.cs.algs4.StdIn;

public class parens 
{
	private static int count_parens(String s)
	{
		int paren_count = 0;
		int len = s.length();
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (c == ')')
				paren_count++;
		}
		return paren_count;
	}

	private static void check(String s, int parens)
	{
		if (count_parens(s) != parens) {
			System.out.println(s + " doesn't have " + parens + " parens");
			System.exit(-1);
		}
	}


	public static void main(String[] args)
	{
		String test1 = "1 + 1)";
		String test2 = "1 + 1) * 2 + 3)))";
		String test3 = "1 + 2) * 3 - 4) * 5 - 6)))";


		check(test1, 1);
		check(test2, 4);
		check(test3, 5);




		/*
		String in = null;
		while (!StdIn.isEmpty()) {
			in = StdIn.readString();
			System.out.println(in);
		}
		*/
	}
}
