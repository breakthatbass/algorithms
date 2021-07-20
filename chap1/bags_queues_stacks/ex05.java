/* 
 * exercise 1.3.5
 *
 * what does the following code fragment print when n is 50? give a high level
 * description of what it does when presented with a positive integer n.
 *
 * answer: prints the binary representation of n (110010 when n is 50)
 *
 * note: the code compiles whether you use the java stdlib stack or the algs4
 * lib stack, however, the java stdlib stack returns '010011' and the algs4 lib
 * returns '110010'...interesting. 
 */

//import java.util.Stack;
import edu.princeton.cs.algs4.Stack;

public class ex05 
{
	private static void dtob(int n)
	{
		Stack<Integer> stack = new Stack<Integer>();
		while (n > 0) {
			stack.push(n % 2);
			n = n/2;
		}
		for (int d : stack) System.out.print(d);
		System.out.println();
	}

	public static void main(String[] args)
	{
		dtob(50);
	}
}
