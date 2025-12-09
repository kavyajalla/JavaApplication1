package Easy;

import java.util.Arrays;

public class MeetingRooms {
	public boolean meetingRooms(int[][] rooms)
	{
//		Collections.sort(rooms, Comparator.comparing((m1,m2) -> (m1[0]- m2[0]))); //NOT CORRECT
		
//		Collections.sort(rooms,(a,b) -> Integer.compare([0],b[0])); //CORRECT

//		Arrays.sort(rooms, (m1,m2)->m1[0]-m2[0]);  //CORRECT
		
		Arrays.sort(rooms, (m1,m2) -> Integer.compare(m1[0], m2[0]));
		
		int prev = rooms[0][1];
		
		for(int i=1; i<rooms.length; i++)
		{
			if(rooms[i][0] < prev)
			{
				return false;
			}
			prev = rooms[i][1];
		}
		
		return true;
	}
}
/**
 * 
LeetCode 252 – Meeting Rooms is a simple interval scheduling problem.

✅ Problem Summary

Given an array of meeting time intervals intervals[i] = [start, end],
determine if a person can attend all meetings.

You can attend all meetings only if no two meetings overlap.

✅ Example

Input:

[[0,30],[5,10],[15,20]]


These intervals overlap because:

Meeting 1: 0–30

Meeting 2: 5–10 (starts before 30 ends)

➡️ Output: false

Input:

[[7,10],[2,4]]


These do not overlap:

2–4

7–10

➡️ Output: true
 */