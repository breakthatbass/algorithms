/*
 * write a program that takes three integer command-line arguments and 
 * prints 'equal' if all three are equal and 'not equal' otherwise.
 *
 */

public class ex03 {
	public static void main(String[] args) {
		// check to make sure we have 3 args
		if (args.length != 3) {
			System.out.println("usage: java ex03 arg1 arg2 arg3");
			System.exit(1);

		} else {
			// args come in as strings so we need to convert to ints
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			int c = Integer.parseInt(args[2]);

			if (a == b && b == c) System.out.println("equal");
			else System.out.println("not equal");	
		}
	}
}
