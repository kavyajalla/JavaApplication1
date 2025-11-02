package App1;

import java.util.Stack;

public class ValidParenthesis {
	public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length() ; i++)
        {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[')
            {
                stack.push(c);
            }
            else if(!stack.isEmpty())
            {
                char top = stack.peek();
                if(c == ')' && top != '(')
                {
                    return false;
                }
                else if(c == '}' && top != '{')
                {
                    return false;
                }
                else if(c == ']' && top != '[')
                {
                    return false;
                }
                stack.pop();
            }
            else
            {
                stack.push(c);
            }
        }

        if(stack.isEmpty())
        {
            return true;
        }

        return false;
    }
    
}

/*
20. Valid Parentheses
Solved
Easy
Topics
premium lock icon
Companies
Hint
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

Example 5:

Input: s = "([)]"

Output: false 
*/