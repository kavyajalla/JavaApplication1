package Medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingCharacters {
	class Solution {
	    public int lengthOfLongestSubstring(String s) {
	        int max = 0;
	        int rIndex = 0;
	        Map<Character, Integer> map = new HashMap<>();
	        for(int i=0; i<s.length(); i++)
	        {
	            char c = s.charAt(i);
	            if(map.containsKey(c))
	            {
	                rIndex = Math.max(map.get(c), rIndex);
	            }
	            map.put(c, i+1);
	            max = Math.max(max , i+1 - rIndex);
	        }
	        return max;
	    }
	}
	/*
	        HashMap<Character,Integer> map = new HashMap();
	        int len = 0;
	        int maxLen = 0;
	        int lastRepeatedIndex = 0;
	        for(int i=0; i<s.length(); i++)
	        {
	            if(map.containsKey(s.charAt(i)))
	            {
	                lastRepeatedIndex = Math.max(map.get(s.charAt(i)), lastRepeatedIndex);
	            }
	            len = i+1 - lastRepeatedIndex;
	            maxLen = Math.max(len,maxLen);
	            map.put(s.charAt(i),i+1);                                 
	        }
	        return maxLen;
	*/

	/*
	 public int lengthOfLongestSubstring(String s) {
	        int max = 0;
	        int rIndex = -1;
	        int len = 0;
	        Map<Character, Integer> map = new HashMap<>();
	        for(int i=0; i<s.length(); i++)
	        {
	            char c = s.charAt(i);
	            if(map.containsKey(c))
	            {
	                rIndex = map.get(c);
	                map.clear();
	                len = 0;
	                map.put(c, i);
	            }
	            else
	            {
	                map.put(c, i);
	                max = Math.max(max, map.size());
	            }
	        }
	        return max;
	    }
	*/
}
/**
 * 3. Longest Substring Without Repeating Characters
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given a string s, find the length of the longest substring without duplicate characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */

