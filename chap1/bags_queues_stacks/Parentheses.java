/*
 * exercise 1.3.4
 *
 * write a stack client Parentheses that reads in a text stream from standard
 * input and uses a stack to determine whether its parentheses are properly
 * balanced.
 *
 * for example, your program should print true for [()]{}{[()()]()} and false
 * for [(]).
 */

import edu.princeton.cs.algs4.Stack;

public class Parentheses {
    
    public static boolean isBalanced(String s)
    {
        char[] parens = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char p: parens) {
            if (p == '(' || p == '{' || p == '[')
                stack.push(p);
            else {
                if (stack.isEmpty()) return false;

                char item = stack.pop();
                if (p == ')' && item != '('
                    || p == '}' && item != '{'
                    || p == ']' && item != '[')
                    return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String pass = "[()]{}{[()()]()}";
        String fail = "[(])";
		
		// i dont read from stdin, instead i just have them as strings
        System.out.println(isBalanced(pass)); // prints true
        System.out.println(isBalanced(fail)); // prints false
    }
}
