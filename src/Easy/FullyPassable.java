package Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Karat Glassdoor question - array
public class FullyPassable {
	public Map<String,List<Integer>> findPassable(char[][] grid) {
		
		Map<String,List<Integer>> result = new HashMap<String, List<Integer>>();
		
		List<Integer> rows = new ArrayList<Integer>();
		for(int i = 0; i<grid.length; i++) {
			boolean pass = true;
			for(int j=0; j<grid[0].length; j++) {
				if(grid[i][j] == '+') {
					pass = false;
					break;
				}
			}
			if(pass) {
				rows.add(i);
			}
		}
		
		List<Integer> cols = new ArrayList<Integer>();
		for(int i = 0; i<grid[0].length; i++) {
			boolean pass = true;
			for(int j=0; j<grid.length; j++) {
				if(grid[j][i] == '+') {
					pass = false;
					break;
				}
			}
			if(pass) {
				cols.add(i);
			}
		}
		
		result.put("rows", rows);
		result.put("columns", cols);
		
		return result;
	}
}
/**
A 2-D grid that consists of '0' and '+'. '+' means impassable and '0' means passable. 
Return the rows and columns indices that are completely passable (all 0's). 
*/

/* ChatGPT solution
public static Map<String, List<Integer>> findPassable(String[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    List<Integer> rows = new ArrayList<>();
    List<Integer> cols = new ArrayList<>();

    for (int i = 0; i < m; i++) {
        boolean passable = true;
        for (int j = 0; j < n; j++) {
            if (!grid[i][j].equals("0")) {
                passable = false;
                break;
            }
        }
        if (passable) rows.add(i);
    }

    for (int j = 0; j < n; j++) {
        boolean passable = true;
        for (int i = 0; i < m; i++) {
            if (!grid[i][j].equals("0")) {
                passable = false;
                break;
            }
        }
        if (passable) cols.add(j);
    }

    Map<String, List<Integer>> result = new HashMap<>();
    result.put("rows", rows);
    result.put("cols", cols);
    return result;
}

*/