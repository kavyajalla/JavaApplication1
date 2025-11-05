package Medium;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
	public int orangesRotting(int[][] grid) {
        int minutes = 0;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[i].length; j++)
            {
                //Rotten found so queue
                if(grid[i][j] == 2)
                {
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j] == 1)
                {
                    fresh++;
                }
            }
        }

        int[][] d = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        //Check queue empty and fresh oranges
        while(!q.isEmpty() && fresh > 0)
        {
            int size = q.size();
            //Track levels
            for(int j=0; j<size; j++)
            {
            int[] pos = q.poll();
            int r = pos[0];
            int c = pos[1];
            //all directions
            for(int i=0; i<d.length; i++)
            {
                int newR = r + d[i][0];
                int newC = c + d[i][1];
                if(newR >= 0 && newR < grid.length && newC >= 0 && newC < grid[0].length && grid[newR][newC] == 1)
                {
                    q.add(new int[] {newR, newC});
                    grid[newR][newC] = 2;
                    fresh--;
                }
            }

            }

            minutes++;
        }

        if(fresh != 0)
        {
            return -1;
        }

        return minutes;
    }
}
/*
 * 994. Rotting Oranges
Solved
Medium
Topics
premium lock icon
Companies
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.
 */
