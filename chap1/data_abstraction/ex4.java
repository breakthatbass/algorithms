/*
 * exercise 1.2.4
 *
 * what does the following code fragment print?
 *
 * it prints:
 *
 * world
 * hello
 *
 */
public class ex4 
{
	public static void main(String[] args)
	{
		String string1 = "hello";
		String string2 = string1;
		string1 = "world";
		System.out.println(string1);
		System.out.println(string2);
	}
}
