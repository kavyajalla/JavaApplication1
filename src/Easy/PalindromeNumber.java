package Easy;

public class PalindromeNumber {
	    public boolean isPalindrome(int x) {   
	        if(x < 0)
	        {
	           return false;
	        }  

	       int rev = 0;
	       int t = x;
	       while(t != 0)
	       {
	        int r = t%10;
	        rev = rev*10 + r;
	        t = t/10;
	       }

	       return x==rev? true:false;
	    }
	/*
	  public boolean isPalindrome(int x) {     
	        // String s = ""+x;
	        char[] c = (""+x).toCharArray();
	        int j = c.length-1;
	        for(int i=0; i<c.length/2; i++)
	        {
	            if(c[i] != c[j])
	            {
	                return false;
	            }
	            j--;
	        }

	        return true;
	    }
	    */
}

/**
 * 9. Palindrome Number
Solved
Easy
Topics
premium lock icon
Companies
Hint
Given an integer x, return true if x is a palindrome, and false otherwise.

 

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 

Constraints:

-231 <= x <= 231 - 1
 */
