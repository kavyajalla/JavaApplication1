package Easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxPairSumInAnArray {
	 public int maxSum(int[] nums) {
	        Map<Integer, List<Integer>> m = new HashMap<>();

	        for(int i=0; i<nums.length ;i++)
	        {
	            int max = largestDigit(nums[i]);
	            m.computeIfAbsent(max , k -> new ArrayList<Integer>()).add(nums[i]);
	        }
	        int max = -1;

	        for(Map.Entry<Integer, List<Integer>> entry : m.entrySet() )
	        {
	            List<Integer> numList = entry.getValue();
	            if(numList.size() < 2){
	                continue;
	            }
	            numList.sort(Collections.reverseOrder()); // Reverse sort of array list
	            int sum = numList.get(0) + numList.get(1);
	            max = Math.max(sum, max);
	        }

	        return max;
	    }

	    int largestDigit(int num)
	    {
	        int max = -1;
	        while(num != 0){
	            int d = num%10;
	            max = Math.max(d, max);
	            num = num/10;
	        }
	        return max;
	    }
}
/*Alternate
 * public int maxSum(int[] nums) {
    int[][] top2 = new int[10][2]; // for digits 0-9
    for (int i = 0; i < 10; i++) {
        top2[i][0] = top2[i][1] = -1;
    }

    for (int num : nums) {
        int d = largestDigit(num);
        
        // update the top 2 max values for this digit
        if (num > top2[d][0]) {
            top2[d][1] = top2[d][0];
            top2[d][0] = num;
        } else if (num > top2[d][1]) {
            top2[d][1] = num;
        }
    }

    int result = -1;

    for (int d = 0; d < 10; d++) {
        if (top2[d][1] != -1) {
            result = Math.max(result, top2[d][0] + top2[d][1]);
        }
    }

    return result;
}

int largestDigit(int num) {
    int max = 0;
    while (num > 0) {
        max = Math.max(max, num % 10);
        num /= 10;
    }
    return max;
}
 */

/**
 * 2815. Max Pair Sum in an Array
Solved
Easy
Topics
premium lock icon
Companies
Hint
You are given an integer array nums. You have to find the maximum sum of a pair of numbers from nums such that the largest digit in both numbers is equal.

For example, 2373 is made up of three distinct digits: 2, 3, and 7, where 7 is the largest among them.

Return the maximum sum or -1 if no such pair exists.

 

Example 1:

Input: nums = [112,131,411]

Output: -1

Explanation:

Each numbers largest digit in order is [2,3,4].

Example 2:

Input: nums = [2536,1613,3366,162]

Output: 5902

Explanation:

All the numbers have 6 as their largest digit, so the answer is 2536 + 3366 = 5902.

Example 3:

Input: nums = [51,71,17,24,42]

Output: 88

Explanation:

Each number's largest digit in order is [5,7,7,4,4].

So we have only two possible pairs, 71 + 17 = 88 and 24 + 42 = 66.
 */
