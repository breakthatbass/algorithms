/*
 * exercise 1.3.10
 *
 * write a filter InfixToPostfix that converts an arithmetic expression
 * from the infix to postfix
 *
 * i had never heard of the terms infix or postfix
 * but i found this resource explaining them:
 * https://web.stonehill.edu/compsci/CS104/Stuff/Infix%20and%20%20postfix%20expressions.pdf
 *
 */
public class ex10 
{
	private static String infix_to_postfix(String s)
	{
		Stack<String> opnds = new Stack<>();
		Stack<String> opors = new Stack<>();

		String[] input = s.split("\\s");

		for (String v : input) {
			if (v.equals("+") || v.equals("-") || v.equals("*") || v.equals("/")) {
				opors.push(v);
			} else if (v.equals(")")) {
				String oper = opors.pop();
				String v2 = opnds.pop();
				String v1 = opnds.pop();

				String sub_exp = v1+v2+oper;
				opnds.push(sub_exp);
			} else if (v.equals("(")) {
				continue;
			} else {
				opnds.push(v);
			}
		}
		return opnds.pop();
	}
	
	public static void main(String[] args)
	{
		String test = "( ( 1 + 2 ) * ( 3 * 4 ) / ( 5 / 6 ) )";

		System.out.println(infix_to_postfix(test));
	}
}
