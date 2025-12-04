package Medium;

public class PermutationInString {
	  public boolean checkInclusion(String s1, String s2) {
	        if(s1.length() > s2.length())
	        {
	            return false;
	        }
	        int[] s1Freq = new int[26];
	        int[] s2Freq = new int[26];

	        for(int i=0; i<s1.length(); i++)
	        {
	            char c=s1.charAt(i);
	            s1Freq[c-'a']++;
	        }

	        for(int i=0;i<s1.length(); i++)
	        {
	            char c= s2.charAt(i);
	            s2Freq[c-'a']++;
	        }

	        if(isPermutation(s1Freq, s2Freq))
	        {
	            return true;
	        }

	        for(int i=s1.length(); i<s2.length(); i++)
	        {
	        	//add current char
	            char c = s2.charAt(i);
	            s2Freq[c-'a']++;

	            //remove old char
	            char d = s2.charAt(i-s1.length());
	            s2Freq[d-'a']--;

	            if(isPermutation(s1Freq, s2Freq))
	            {
	                return true;
	            }
	        }


	        return false;
	    }

	    boolean isPermutation(int[] s1, int[] s2)
	    {
	        for(int i=0; i<s1.length; i++)
	        {
	            if(s1[i] != s2[i])
	            {
	                return false;
	            }
	        }
	        return true;
	    }
}
