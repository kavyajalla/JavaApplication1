package Medium;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOFIslands {
	 public int numIslands(char[][] grid) {
	        int numOfIslands = 0;
	        Queue<int[]> q = new LinkedList<>();

	        //BFS
	        for(int i=0; i<grid.length; i++)
	        {
	            for(int j=0; j<grid[i].length; j++)
	            {
	                if(grid[i][j] == '0')
	                {
	                    continue;
	                }

	                if(grid[i][j] == '1')
	                {
	                    numOfIslands++;
	                    q.offer(new int[]{i,j});
	                }

	                while(!q.isEmpty())
	                {
	                    int[] pos = q.poll();
	                    int r = pos[0];
	                    int c = pos[1];

	                    if(r-1 >= 0 && grid[r-1][c] == '1')
	                    {
	                        q.offer(new int[]{r-1,c});
	                        grid[r-1][c] = '0';
	                    }

	                    if(r+1 < grid.length && grid[r+1][c] == '1')
	                    {
	                        q.offer(new int[]{r+1,c});
	                        grid[r+1][c] = '0';
	                    }

	                    if(c-1 >= 0 && grid[r][c-1] == '1')
	                    {
	                        q.offer(new int[]{r,c-1});
	                        grid[r][c-1] = '0';
	                    }

	                    if(c+1 < grid[0].length && grid[r][c+1] == '1')
	                    {
	                        q.offer(new int[]{r,c+1});
	                        grid[r][c+1] = '0';
	                    }
	                }
	            }
	        }

	        return numOfIslands;
	    }
}


/*
//Works partially
   public int numIslands(char[][] grid) {
        int numOfIslands = 0;
        int land = 0;

        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[i].length; j++)
            {
                if(grid[i][j] == '1')
                {
                    q.offer(new int[]{i,j});  
                    land++;
                }
            }
        }

        int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty() && land > 0)
        {
            int[] pos = q.poll();
            int r = pos[0];
            int c = pos[1];

            for(int i=0; i<d.length; i++)
            {
                int newR = r + d[i][0];
                int newC = c + d[i][1];
                if(newR >= 0 && newR < grid.length && newC >=0 && newC < grid[0].length && 
                (grid[newR][newC] == '1' || grid[newR][newC] == '2'))
                {
                    grid[newR][newC] = 2;
                    land--;
                }
            }

            if(grid[r][c] == '1')
            {
                numOfIslands++;
            }
        }

        return numOfIslands;
    }
*/


/*
Correct but runs into out of stack space since too many nestde calls

class Solution {
     public int numIslands(char[][] grid) {
        int numOfIslands = 0;


        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[i].length; j++)
            {
                if(grid[i][j] == '1')
                {
                    numOfIslands++;
                    dfs(grid, i, j);
                }
            }
        }

        return numOfIslands;
    }
    
    private void dfs(char[][] grid, int i, int j)
    {
        //Invalid cases
        if(i<0 || j<0 || i>= grid.length || j>=grid[0].length || grid[i][j]=='0')
        {
            return;
        }

        //Already visited so amrk it 0
        grid[i][j] = 0;

        //Discover land in all directions
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}
*/


//WORKING CODE BELOW
/*
//     public int numIslands(char[][] grid) {
//         if(grid.length == 0)
//         {
//             return 0;
//         }
//         int totalIslands  = 0;
//         boolean[][] visited= new boolean[grid.length][grid[0].length];
        
//         for(int i=0; i < grid.length;i++)
//         {
//             for(int j=0; j < grid[0].length; j++)
//             {
//                 if(visited[i][j] == true)
//                 {
//                     continue;
//                 }
//                 int isIsland = traverseMatrix(i, j, grid, visited);
//                 if(isIsland > 0)
//                 {
//                     totalIslands++;
//                 }
//             }
//         }
        
//         return totalIslands;
//     }
    
//     public int traverseMatrix(int i, int j, char[][] grid, boolean[][] visited)
//     {
//         int totalIslands = 0;
//         List<Integer[]> nodesToExplore = new ArrayList<Integer[]>();
//         nodesToExplore.add(new Integer[] {i,j});
        
//         while(!nodesToExplore.isEmpty())
//         {
//             Integer[] currentNode = nodesToExplore.get(nodesToExplore.size() - 1);
//             nodesToExplore.remove(nodesToExplore.size() - 1);
//             i = currentNode[0];
//             j = currentNode[1];
            
//             if(visited[i][j] == true)
//             {
//                 continue;
//             }
//             visited[i][j] = true;
//             if(grid[i][j] == '0')
//             {
//                 continue;
//             }
            
//             List<Integer[]> neighborsToExplore = getNeighborsToExplore(i, j, grid, visited);
//             for(Integer[] node : neighborsToExplore)
//             {
//                 nodesToExplore.add(node);
//             }
            
//             totalIslands++;
//         }
        
//         return totalIslands;
//     }
    
//     public List<Integer[]> getNeighborsToExplore(int i, int j, char[][] grid, boolean[][] visited)
//     {
//         List<Integer[]> nodesToExplore = new ArrayList<Integer[]>();
        
//         if(i>0 && visited[i-1][j] != true)
//         {
//             nodesToExplore.add(new Integer[] {i-1,j});
//         }
//         if(j>0 && visited[i][j-1] != true)
//         {
//             nodesToExplore.add(new Integer[] {i, j-1});
//         }
//         if(i< grid.length-1 && visited[i+1][j] != true)
//         {
//             nodesToExplore.add(new Integer[] {i+1,j});
//         }
//         if(j< grid[0].length-1 && visited[i][j+1]!= true)
//         {
//             nodesToExplore.add(new Integer[] {i,j+1});
//         }
        
//         return nodesToExplore;
//     }
*/


/**
 * 200. Number of Islands
Solved
Medium
Topics
premium lock icon
Companies
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
 */
