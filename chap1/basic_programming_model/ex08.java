/*
 * what do each of the following print?
 */

public class ex08
{
	public static void main(String args[])
	{
		System.out.println('b');
		// b
		// this is just simply printing a char

		System.out.println('b' + 'c');
		// 197
		// the ascii value for the char 'b' is 98 and the value for 'c' is 99.
		// 98 + 99 = 197
		// the interpreter seems to convert them to ints because of the '+'

		System.out.println((char) ('a' + 4));
		// e
		// this takes the ascii value of 'a' (97) and adds 4 to it (101)
		// (char) converts 101 to the char associated with that number which is e.
		// all char underneath are actually integers

	}
}
