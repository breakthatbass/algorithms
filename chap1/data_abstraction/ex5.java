/*
 * exercise 1.2.5
 *
 * what does the following code fragment print?
 *
 * prints:
 *
 * Hello World
 *
 * the reason is that both .toUpperCase and .substring methods return an affected
 * varible. neither method has any effect on the original variable.
 */
public class ex5 
{
	public static void main(String[] args)
	{
		String s = "Hello World";
		s.toUpperCase();
		s.substring(6, 11);
		System.out.println(s);
	}
}
