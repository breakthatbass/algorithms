/*
 * sorting three numbers:
 * suppose that the variable a, b, c, and t are all of the same numeric
 * primitive type. show that the following code puts a, b, and c in ascending
 * order:
*/
public class ex26 
{
	public static void main(String[] args)
	{
		int a = 45;
		int b = 12;
		int c = 67;
		int t; // t is a temp variable for swapping

		if (a > b) {t = a; a = b; b = t;}
		if (a > c) {t = a; a = c; c = t;}
		if (b > c) {t = b; b = c; c = t;}

		System.out.println(a + " " + b + " " + c);
	}
}
