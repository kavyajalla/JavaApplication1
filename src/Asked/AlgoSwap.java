package Asked;

public class AlgoSwap {
	public static int algoSwaps(int[] arr)
	{
		int count = 0;
		for(int i=0; i<arr.length; i++)
		{
			for(int j = i+1; j<arr.length; j++)
			{
				if(arr[i] < arr[j])
				{
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					count++;
				}
			}
		}
		return count;
	}
	
	public static void main(String args[]) {
		int[] arr = new int[] {3,1,2};
		System.out.println(algoSwaps(arr));
	}
}

//amazon round 1 - 2021
/**
1. Algo Swap

Question summary:

You’re given an algorithm that iterates through all pairs (i, j) and swaps a[i] and a[j] if a[i] < a[j].
You’re asked: “How many swaps in total will happen?”
Example

Let’s take an array:
a = [3, 1, 2]

All pairs (i < j):

(0,1): 3<1? no
(0,2): 3<2? no
(1,2): 1<2? yes -> swap


After that swap:
a = [3, 2, 1]

Total swaps = 1
*/


///Chatgpt solution
/*
 * class Solution {
    public int countSwaps(int[] a) {
        int swaps = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] < a[j]) {
                    swaps++;
                    // actual swap if you want to simulate:
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return swaps;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {3, 1, 2};
        System.out.println(s.countSwaps(arr)); // Output: 1
    }
}

Faster O(n log n) (If needed)

If you just need the count (not actual swaps), you can do this efficiently by:

Counting inversions in descending order (i.e., pairs a[i] < a[j]).

Use a modified merge sort.
*/