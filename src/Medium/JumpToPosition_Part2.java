package Medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//Karat Glassdoor question - HashMaps, BFS
public class JumpToPosition_Part2 {
	public boolean jumpToEnd(int start,
			Map<Integer, Integer> teleporters,
			int diceSides,
			int boardEnd) {
		
		Set<Integer> visited = new HashSet<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		
		while(!q.isEmpty()) {
			int pos = q.poll();
			
			if (pos == boardEnd) {
				return true;
			}
			
			for(int roll = 1; roll<diceSides; roll++) {
				int next = pos+roll;
				
				if(teleporters.containsKey(next)) {
					next = teleporters.get(next);
				}
				
				if(!visited.contains(next) && next<boardEnd) {
					q.offer(next);
					visited.add(next);
				}
			}
		}
		
		return false;
	}
}
/**
Q2. Modified version of Q1. Players move by rolling a die as many times as they wish to, 
and the goal is to determine if they can reach the last square on the board from a given starting position.

*/