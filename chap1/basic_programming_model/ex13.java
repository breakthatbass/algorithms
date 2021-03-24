/*
 * write a code fragment to print the transposition (rows and columns changed)
 * of a two-dimensional array with m rows and n coloumns.
 *
 * i didn't really get these directions at first. i had to look up the
 * definition of transpose it basically just means to cause two things to change
 * places with each other.
 *
 * so in the case of this program, im just going to print from each row and then
 * move the column ahead by one
 */

public class ex13
{
	public static void main(String[] args)
	{
		int i, j;
		int a[][] = {
			{2, 5, 3},
			{4, 1, 6}
		};

		i = 0;
		for (j = 0; j < a[i].length; j++) {
			for (i = 0; i < a.length; i++) {
				System.out.print(a[i][j]);
			}
			i = 0;
			System.out.println();
		}
	}
}




 
