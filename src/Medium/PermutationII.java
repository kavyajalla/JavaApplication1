package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationII {
	 public List<List<Integer>> permuteUnique(int[] nums) {
	        Arrays.sort(nums);
	        boolean[] visited = new boolean[nums.length];
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        dfs(nums, visited, new ArrayList<Integer>(), result);
	        return result;
	    }

	    void dfs(int[] nums, boolean[] visited, List<Integer> curr, List<List<Integer>> result)
	    {
	        if(curr.size() == nums.length)
	        {
	            result.add(new ArrayList<Integer>(curr));
	            return;
	        }

	        for(int i=0; i<nums.length; i++)
	        {
	            if(visited[i] == true)
	            {
	                continue;
	            }

	            // If nums[i] == nums[i-1] and the previous identical one wasn't used,
	            // then using this one would create duplicate permutations.
	            if(i>0 && nums[i-1] == nums[i] && visited[i-1]!=true)
	            {
	                continue;
	            }

	            visited[i] = true;
	            curr.add(nums[i]);
	            dfs(nums, visited, curr, result);

	            curr.remove(curr.size()-1);
	            visited[i] = false;
	        }
	    }
}
/**
 * 47. Permutations II
Solved
Medium
Topics
premium lock icon
Companies
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

 

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

Constraints:

1 <= nums.length <= 8
-10 <= nums[i] <= 10
 */