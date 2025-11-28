package Medium;

class WordSearch {
	//Depth First Search DFS
	boolean isWordFound(char[][] board, String word)
	{
		for(int i=0; i<board.length; i++)
		{
			for(int j=0; j<board[i].length; j++)
			{
				if(dfs(board, i, j, word, 0))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	boolean dfs(char[][] board, int i, int j, String word, int len)
	{
		//Exit condition
		if( i<0 || i>=board.length || j<0 || j>=board[i].length ||
				word.charAt(len) != board[i][j])
		{
			return false;
		}
		
		char temp = board[i][j];
		board[i][j] = '#'; //Marking it visited in this execution
		
		boolean found = dfs(board, i-1, j, word, len+1) ||
				dfs(board, i+1, j, word, len+1) ||
				dfs(board, i, j-1, word, len+1) ||
				dfs(board, i, j+1, word, len+1);
		
		board[i][j] = temp;
		
		return found;
	}
}

/**
 * 79. Word Search
Solved
Medium
Topics
premium lock icon
Companies
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.


Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
 */