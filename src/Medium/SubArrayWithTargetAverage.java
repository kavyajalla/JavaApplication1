package Medium;

import java.util.HashSet;
import java.util.Set;

//Prefix Sum + HashSet
//Swiggy interview = Medium post
public class SubArrayWithTargetAverage {
	public boolean subArrayWithTarget(int[] nums, double target) {
		
		Set<Double> seen = new HashSet<>();
		seen.add(0.0); //for index 0 prefixSum
		
		double prefix = 0;
		
		for(int n : nums) {
			prefix += n-target;
			
			if(seen.contains(prefix))
			{
				return true;
			}
			
			seen.add(prefix);
		}
		
		return false;
	}
}
/**
Question 1: Sub-array with Target Average
Duration: 1 hour, Format: DSA
Given an array and a target average, find if any contiguous subarray has that exact average.
I went with the prefix sums plus a little algebraic manipulation, felt straightforward, but the constraints made it tricky.

LOGIC:
average = sum/len;
sum/len = target;
sum = target *len;
sum - target*len = 0;
(nums[i] .... nums[j]) - target*(j-i+1) = 0;
nums[1]-target + nums[i+1]-target + .... + nums[j]-target = 0;
*/