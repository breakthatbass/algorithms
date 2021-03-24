/*
 * write a code fragment that prints the contents of a two dimensional boolean
 * array, using * to represent true and a space to represent false. include row
 * and column numbers.i
 */

public class ex11
{
	public static void main(String args[])
	{
		boolean a[][] = {
			{true, false, true, false, false, true, true},
			{true, true, true, false, true, true, false},
			{true, false, true, true, true, true, true}
		};
		print_bool_arr(a);
	}

	public static void print_bool_arr(boolean[][] a)
	{
		int i;
		int j;
		for (i = 0; i < a.length; i++) {
			for (j = 0; j < a[i].length; j++) {
				if (a[i][j])
					System.out.print("*");
				else
					System.out.print(" ");
			}
		}
	}
}
