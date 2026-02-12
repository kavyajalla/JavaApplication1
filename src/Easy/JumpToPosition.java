package Easy;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Karat Glassdoor question - HashMaps
public class JumpToPosition {
	public Set<Integer> positionsFinder(int start,
			int diceSides,
			Map<Integer, Integer> teleporters,
			int boardEnd
			) {
		Set<Integer> result = new HashSet<Integer>();
		
		for(int roll=1; roll<= diceSides; roll++) {
			int next = start + roll;
			if(next>boardEnd) {
				continue;
			}
			
			if(teleporters.containsKey(next)) {
				next = teleporters.get(next);
			}
			
			result.add(next);
		}
		
		return result;
	}
}
/**
You are playing a board game (1-D array) where the player moves by rolling a die with the number of sides given and is allowed to roll it once.
 You are also given a list of teleporters that move the player from one square to another.
  The starting and ending squares are given as well. Return a distinct list of positions where the player can potentially jump to.
*/
//Karat Glassdoor question