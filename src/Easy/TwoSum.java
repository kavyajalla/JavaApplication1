package Easy;

import java.util.HashMap;
import java.util.Map;

//Array, HashTable
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++)
        {
            int com = target - nums[i];
            if(map.containsKey(com))
            {
                return new int[] {i, map.get(com)};
            }
            else
            {
                map.put(nums[i],i);
            }
        }
        return ret;
	}
}
/*
int[] res = new int[2];
HashMap<Integer,Integer> m = new HashMap<Integer,Integer>();
for(int i=0; i<nums.length; i++)
{
    int diff = target - nums[i];
    if(m.containsKey(diff))
    {
        return new int[]{m.get(diff), i};
    }
    else
    {
        m.put(nums[i],i);
    }
}
return res;

// int[] result = new int[2];
// for(int i=0; i<nums.length; i++)
// {
//     result[0] = i;
//     for(int j=i+1; j<nums.length; j++)
//     {
//          int diff =  target - nums[i];
//         if(nums[j] == diff)
//         {
//             result[1] = j;
//             return result;
//         }
//     } 
// }
// return result;
*/

/**
 * 1. Two Sum
Solved
Easy
Topics
premium lock icon
Companies
Hint
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
*/
