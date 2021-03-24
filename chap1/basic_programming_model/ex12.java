/* what does the following code fragment print?
 *
 * 0
 * 1
 * 2
 * 3
 * 4
 * 4
 * 3
 * 2
 * 1
 * 0
 */

public class ex12
{
	public static void main(String[] args)
	{
		int i;
		int a[] = new int[10];

		for (i = 0; i < 10; i++)
			a[i] = 9-i;
		for (i = 0; i < 10; i++)
			a[i] = a[a[i]];
		for (i = 0; i < 10; i++)
			System.out.println(a[i]);	
	}
}
