package Medium;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland {
	  public int maxAreaOfIsland(int[][] grid) {
	        Queue<int[]> q = new LinkedList<int[]>();
	        int max = 0;
	        int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

	        for(int i=0; i<grid.length; i++)
	        {
	            for(int j=0; j<grid[0].length; j++)
	            {
	                if(grid[i][j] == 0)
	                {
	                    continue;
	                }

	                int area = 0;
	                if(grid[i][j] == 1)
	                {
	                    q.offer(new int[]{i,j});
	                    grid[i][j] = 0;
	                    area++;
	                }

	                while(!q.isEmpty())
	                {
	                    int[] pos = q.poll();
	                    int r = pos[0];
	                    int c = pos[1];

	                    for(int k=0; k<dir.length; k++)
	                    {
	                        int r1 = r + dir[k][0];
	                        int c1 = c + dir[k][1];

	                        if(r1>=0 && r1<grid.length && c1>=0 && c1<grid[0].length && grid[r1][c1] == 1)
	                        {
	                            q.offer(new int[]{r1,c1});
	                            area++;
	                            grid[r1][c1] = 0;
	                        }
	                    }
	                }

	                max = Math.max(area, max);
	            }
	        }

	        return max;
	    }
}
/**
695. Max Area of Island
Solved
Medium
Topics
premium lock icon
Companies
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.

 

Example 1:


Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.
Example 2:

Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 50
grid[i][j] is either 0 or 1
*/