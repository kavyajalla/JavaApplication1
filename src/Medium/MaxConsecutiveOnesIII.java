package Medium;

//Sliding window, Array , Binary Search, Prefix Sum
public class MaxConsecutiveOnesIII {
	 public int longestOnes(int[] nums, int k) {
	        int count = 0;
	        int max = 0;
	        int left = 0;
	        for(int right=0; right<nums.length; right++)
	        {
	            if(nums[right] == 0)
	            {
	                count++;
	            }
	            
	            while(count > k)
	            {
	                if(nums[left] == 0)
	                {
	                    count--;
	                }
	                left++;
	            }

	            max = Math.max(max, right-left+1);
	        }

	        return max;
	    }
}

/*
 *   public int longestOnes(int[] nums, int k) {
        int st = 0;
        int count = 0;
        int max = 0;
        for(int end = 0; end<nums.length; end++)
        {
            if(nums[end] == 0)
            {
                count++;
            }

            while(count > k)
            {
                if(nums[st] == 0)
                {
                    count--;
                }
                st++;
            }

            if(count <= k)
            {
                int len = end - st + 1;
                max = Math.max(len, max);
            }
        }
        return max;
    }
 */

/**
 * 1004. Max Consecutive Ones III
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

 

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
0 <= k <= nums.length
*/
