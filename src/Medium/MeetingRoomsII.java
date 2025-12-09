package Medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
	
	public int roomsRequired(int[][] rooms)
	{
		Arrays.sort(rooms, (a,b) -> Integer.compare(a[0], b[0]));
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(); //minHeap
		
//		PriorityQueue<Integer> maxHeap = new PriorityQueue((a,b) -> Integer.compare(b, a)) //maxHeap
		
		int end = rooms[0][1];
		queue.offer(end);

		for(int i=1; i<rooms.length; i++)
		{
			//rooms is free, previous meeting(with lowest finish time) has ended
			if(rooms[i][0] >= queue.peek())
			{
				queue.poll();
			}
			
			//add room for this meeting
			queue.offer(rooms[i][1]);
		}
		
		return queue.size();
	}
}
/**
LeetCode 253 — Meeting Rooms II
This is the harder version of Meeting Rooms (LC 252).

✅ Problem Summary

You're given a list of meeting intervals:

[[start1, end1], [start2, end2], ...]


Your task:

👉 Return the minimum number of meeting rooms required so all meetings can take place without conflict.

🔍 Example
Input:
[[0, 30], [5, 10], [15, 20]]

Output:
2


Why?

Meeting 1: 0–30

Meeting 2: 5–10

Meeting 3: 15–20

At time 5, meetings 1 and 2 overlap → need 2 rooms.

*/