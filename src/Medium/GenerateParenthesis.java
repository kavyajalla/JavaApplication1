package Medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	 public List<String> generateParenthesis(int n) {
	        List<String> result = new ArrayList<String>();
	        recursive(result, 0, 0, n, "");
	        return result;
	    }

	    public void recursive(List<String> list, int open, int close, int len, String paren)
	    {
	        if(paren.length() == len*2)
	        {
	            list.add(paren);
	        }

	        if(open < len)
	        {
	            recursive(list, open+1, close, len, paren + "(");
	        }

	        if(close < open)
	        {
	            recursive(list, open, close+1, len, paren + ")");
	        }
	    }
}

/**
*22. Generate Parentheses
Solved
Medium
Topics
premium lock icon
Companies
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
*/