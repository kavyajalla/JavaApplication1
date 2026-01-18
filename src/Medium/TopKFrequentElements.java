package Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
//Array, Hash Table, Divide and Conquer, Sorting, Heap (Priority Queue), Bucket Sort, Counting, Quickselect
public class TopKFrequentElements {
	
	//Max heap approach
	public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        //Defining max heap here
        PriorityQueue<Map.Entry<Integer,Integer>> q = new PriorityQueue<Map.Entry<Integer, Integer>>(
        		(a,b) -> Integer.compare(b.getValue(), a.getValue()));

        for(int i=0; i<nums.length; i++) {
            int freq =  map.getOrDefault(nums[i], 0)+1;
            map.put(nums[i], freq);
        }

        for(Map.Entry<Integer, Integer> kv: map.entrySet()) {
            q.offer(kv);
        }

        int[] result = new int[k];
        int curr = 0;

        while(!q.isEmpty() && curr<k) {
            Map.Entry<Integer, Integer> p = q.poll();
            result[curr] = p.getKey();
            curr++;
        }

        return result;
    }
}

/* CHATGPT solution - optimal minheap appraoch
 public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap();
        for(int i=0; i<nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0)+1);
        }

        //Stores smalles value in front of queue.
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>(
            (a,b) -> Integer.compare(a[1], b[1]));

        for(Map.Entry<Integer, Integer> kv:freq.entrySet()) {
            minHeap.offer(new int[]{kv.getKey(), kv.getValue()});

            if(minHeap.size() > k) {
                minHeap.poll(); ///remove the lowest freq element
            }
        }

        int[] result = new int[k];
        int j=0;
        while(!minHeap.isEmpty()) {
            result[j] = minHeap.poll()[0];
            j++;
        }

        return result;
    }

*/