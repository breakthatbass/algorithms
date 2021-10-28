/*
 * exercise 1.3.9 write a program that from standard input an expression
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
	public static void main(String[] args)
	{
		while (!StdIn.isEmpty()) {
			String in = StdIn.readString();
			System.out.println(in);
		}
	}
}
