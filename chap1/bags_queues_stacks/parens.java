/*
 * exercise 1.3.9
 *
 * BUGGY... 
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
import edu.princeton.cs.algs4.Stack;

public class parens 
{
	private static String fix_parens(String s)
	{
		Stack<String> opd = new Stack<>(); // operands
		Stack<String> opr = new Stack<>(); // operators

		String[] input = s.split("\\s");

		for (String v : input) {
			if (v.equals("(")) {

			
			// if we have an operator
			} else if (v.equals("+") || v.equals("-") || v.equals("*") || v.equals("/")) {
				opr.push(v);
			} else if (v.equals(")")) {
				// we've reached a closing paren
				// let's pop what we need to build a sub expression
				String op = opr.pop();
				String v2 = opd.pop();
				String v1 = opd.pop();

				// put it all together
				String sub_exp = "(" + v1 + " " + op + " " + v2 + ")";
				opd.push(sub_exp);
			} else {
				opd.push(v);
			}
		}
		return opd.pop();
	}

	
	public static void main(String[] args)
	{
		String i = args[0];

		String test1 = "1 + 2 ) * 3 - 4) * 5 - 6)))";
		String test2 = "1+1)";

		System.out.println(fix_parens(test1));
		System.out.println(fix_parens(test2));
		System.out.println(fix_parens(i));
	}
}
