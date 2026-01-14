package Medium;

import java.util.HashMap;
import java.util.Map;

//Array, Hash Table, Prefix Sum
public class SubarraySumEqualsK {
	public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        map.put(0,1);

        int prefixSum = 0;
        int count = 0;

        for(int i=0; i<nums.length; i++) {
            prefixSum += nums[i];

            if(map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum , 0) + 1);
        }

        return count;
    }
}
//What about storing sum frequencies in a hash table? Will it be useful?
//sum(i,j)=sum(0,j)-sum(0,i), where sum(i,j) represents the sum of all the elements from index i to j-1. Can we use this property to optimize it.
/**
560. Subarray Sum Equals K
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 

Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
*/