package Medium;

import java.util.LinkedList;
import java.util.Queue;

//Karat Glassdoor question - BFS
public class FullyPassable_Part2 {
	public int[] bfsPassable(int x, int y, char[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] visited = new boolean[m][n];
		int[] st = new int[] {x,y};
		q.add(st);
		visited[x][y] = true;
		
		int[][] d = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
		
		while(!q.isEmpty()) {
			int[] rc = q.poll();
			int r = rc[0];
			int c = rc[1];
			
			if(!(r==x && c==y)) {
				if((r==0 || r==m-1) && (c==0 || c==n-1)) {
					return new int[] {r,c};
				}
			}
			
			for(int[] dir : d) {
				int r1 = r+dir[0];
				int c1 = c+dir[1];
				
				if(r1>=0 && r1<m && c1>=0 && c1<n 
						&& grid[r1][c1]=='0' && visited[r1][c1]!= true) {
					q.offer(new int[] {r1,c1});
				}
			}
		}
		return new int[] {-1};
	}
}
/**
Modified version of Q1. You are now given a starting cell, which is on one corner of the grid.
 You can travel in all 4 directions of cells that are passable. 
 You have to reach any other passable cell that is on the corner of the grid, which has the minimum distance from the starting cell. 
 Return the coordinates of the destination cell. Return -1 if not possible
*/
//ChatGPT solution
/*
public static int[] nearestCorner(String[][] grid, int startRow, int startCol) {
    int m = grid.length;
    int n = grid[0].length;

    boolean[][] visited = new boolean[m][n];
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{startRow, startCol});
    visited[startRow][startCol] = true;

    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    while (!queue.isEmpty()) {
        int[] curr = queue.poll();
        int r = curr[0];
        int c = curr[1];

        if ((r == 0 || r == m-1) &&
            (c == 0 || c == n-1) &&
            !(r == startRow && c == startCol)) {
            return new int[]{r, c};
        }

        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n &&
                !visited[nr][nc] &&
                grid[nr][nc].equals("0")) {
                visited[nr][nc] = true;
                queue.add(new int[]{nr, nc});
            }
        }
    }

    return new int[]{-1};
}

*/