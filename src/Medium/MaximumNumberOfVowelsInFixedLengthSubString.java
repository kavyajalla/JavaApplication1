package Medium;

import java.util.HashSet;
import java.util.Set;

//Sliding window
public class MaximumNumberOfVowelsInFixedLengthSubString {
	  public int maxVowels(String s, int k) {
	        Set<Character> vowels = new HashSet<Character>();
	        vowels.add('a');
	        vowels.add('e');
	        vowels.add('i');
	        vowels.add('o');
	        vowels.add('u');

	        int count = 0;
	        int max = 0;
	        for(int i=0; i<k; i++)
	        {
	            if(vowels.contains(s.charAt(i)))
	            {
	                count++;
	            }
	        }
	        max = count;
	        for(int i=k; i<s.length(); i++)
	        {
	            int curr = count;
	            char c = s.charAt(i-k);
	            if(vowels.contains(c))
	            {
	                curr--;
	            }
	            if(vowels.contains(s.charAt(i)))
	            {
	                curr++;
	            }
	            max = Math.max(max, curr);
	            count = curr;
	        }

	        return max;
	    }
}
/*
 *     public int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int len = s.length();
        int max = 0;
        int curr = 0;

        for(int i=0; i<k; i++)
        {
            char c = s.charAt(i);
            if(vowels.contains(c))
            {
                curr++;
            }
        }
        max = curr;

        for(int i=k; i<len; i++)
        {
            char c=s.charAt(i);
            if(vowels.contains(c))
            {
                curr++;
            }
            char old = s.charAt(i-k);
            if(vowels.contains(old))
            {
                curr--;
            }
            max = Math.max(max, curr);
        }

        return max;
    }
 */

/**
 * 1456. Maximum Number of Vowels in a Substring of Given Length
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

 

Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
Example 2:

Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.
Example 3:

Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.
 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
1 <= k <= s.length
*/
