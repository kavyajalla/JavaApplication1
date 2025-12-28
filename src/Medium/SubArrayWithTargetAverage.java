package Medium;

//Prefix Sum + HashSet
//Swiggy interview = Medium post
public class SubArrayWithTargetAverage {
	public boolean subArrayWithTarget(int[] nums, double target) {
		int sum = 0;
		double average = 0;
		int st = 0;
		if(nums[0] == target) {
			return true;
		}
		
		for(int i=0; i<nums.length; i++) {
			average = sum/(i+1-st);
			if(average > target) {
				sum += nums[i] - nums[i-st];
			} else if(average == target){
				return true;
			} else {
				sum += nums[i];
			}
		}
		
		return false;
	}
}
/**
Question 1: Subarray with Target Average
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