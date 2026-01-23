package Medium;

import java.util.ArrayList;
import java.util.List;

//Hash Table, String, Sliding Window
public class FindAllAnagramsInAString {
	public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList();
        int sLen = s.length();
        int pLen = p.length();
        
        if(sLen < pLen)
        {
            return result;
        }
        
        int[] pFreq = new int[26];
        int[] sFreq = new int[26];
        
        for(int i=0; i<pLen; i++)
        {
            char c = p.charAt(i);
            pFreq[c-'a']++;
        }

        for(int i=0; i<pLen; i++)
        {
            char c = s.charAt(i);
            sFreq[c-'a']++;
        }

        if(isAnagram(pFreq, sFreq))
        {
            result.add(0);
        }

        for(int i=pLen; i<sLen; i++)
        {
            char c = s.charAt(i);
            boolean ana = false;
            
            //add current char
            sFreq[c-'a']++;

            //remove old char
            sFreq[s.charAt(i-pLen)-'a']--;

            //check if anagram
            ana = isAnagram(pFreq, sFreq);

            if(ana)
            {
                result.add(i-pLen +1);
            }
        }
        return result;
    }

    boolean isAnagram(int[] word, int[] p)
    {
        for(int i=0; i<word.length; i++)
        {
            if(word[i] != p[i])
            {
                return false;
            }
        }
        return true;
    }
}
/**
 * 438. Find All Anagrams in a String
Solved
Medium
Topics
premium lock icon
Companies
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

 

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 

Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.
 * 
 */

class Sol1 {
	public List<String> findAnagrams(String s, String p) {
		
		int[] sFreq = new int[26];
		int[] pFreq = new int[26];
		List<String> res= new ArrayList();
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			sFreq[c-'a']++;
		}
		
		for(int i=0; i<p.length(); i++) {
			char c = p.charAt(i);
			pFreq[c-'a']++;
		}
		
		for(int i=0; i<p.length(); i++) {
			char c = s.charAt(i);
			sFreq[c-'a']++;
		}
		
		if(isAnagram(sFreq, pFreq)) {
			res.add(s.substring(0, p.length()));
		}
		
		for(int i=p.length(); i<s.length(); i++) {
			char c = s.charAt(i);
			sFreq[c-'a']++;
			char d = s.charAt(i-p.length());
			sFreq[d-'a']--;
			if(isAnagram(sFreq, pFreq)) {
				res.add(s.substring(i,i));
			}
		}
		
		return res;
	}
	
	public boolean isAnagram(int[] s, int[] p) {
		for(int i=0;i<s.length; i++) {
			if(s[i] != p[i]) {
				return false;
			}
		}
		return true;
	}
}

