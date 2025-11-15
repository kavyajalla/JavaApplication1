package Medium;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
	  public boolean isValidSudoku(char[][] board) {
	        //row checks
	        for(int r = 0; r<9 ; r++)
	        {
	            if(!isValid(r,r+1,0,9, board))
	            {
	                return false;
	            }
	        }

	        //column checks
	        for(int c = 0; c<9 ; c++)
	        {
	            if(!isValid(0,9,c,c+1, board))
	            {
	                return false;
	            }
	        }

	        //Grid checks
	        for(int r=0; r<9; r = r+3)
	        {
	            for(int c=0; c<9; c = c+3)
	            {
	                if(!isValid(r, r+3, c, c+3, board))
	                {
	                    return false;
	                }
	            }
	        }

	        return true;
	    }

	    public boolean isValid(int rl, int rh, int cl, int ch, char[][] board)
	    {
	        Set<Character> val = new HashSet<>();
	        for(int i=rl; i<rh; i++)
	        {
	            for(int j=cl; j<ch; j++)
	            {
	                if(board[i][j] == '.')
	                {
	                    continue;
	                }
	                if(val.contains(board[i][j]))
	                {
	                    return false;
	                }
	                val.add(board[i][j]);
	            }
	        }
	        return true;
	    }
}

/*//My solution, works but not good, hardcoded
 * 	public boolean isValidSudoku(char[][] board) {
        return (
        isValid(0,2,0,2, board) && isValid(0,2,3,5, board) && isValid(0,2,6,8, board) &&
        isValid(3,5,0,2, board) && isValid(3,5,3,5, board) && isValid(3,5,6,8, board) &&
        isValid(6,8,0,2, board) && isValid(6,8,3,5, board) && isValid(6,8,6,8, board) &&
        isValid(0,0,0,8, board) && isValid(1,1,0,8, board) && isValid(2,2,0,8, board) &&
        isValid(3,3,0,8, board) && isValid(4,4,0,8, board) && isValid(5,5,0,8, board) &&
        isValid(6,6,0,8, board) && isValid(7,7,0,8, board) && isValid(8,8,0,8, board) &&
        isValid(0,8,0,0, board) && isValid(0,8,1,1, board) && isValid(0,8,2,2, board) &&
        isValid(0,8,3,3, board) && isValid(0,8,4,4, board) && isValid(0,8,5,5, board) &&
        isValid(0,8,6,6, board) && isValid(0,8,7,7, board) && isValid(0,8,8,8, board)
        );
    }

    public boolean isValid(int rl, int rh, int cl, int ch, char[][] board)
    {
        Set<Character> val = new HashSet<>();
        for(int i=rl; i<=rh; i++)
        {
            for(int j=cl; j<=ch; j++)
            {
                if(board[i][j] == '.')
                {
                    continue;
                }
                if(val.contains(board[i][j]))
                {
                    return false;
                }
                val.add(board[i][j]);
            }
        }
        return true;
    }
 */
/**
 * 36. Valid Sudoku
Solved
Medium
Topics
premium lock icon
Companies
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 

Example 1:


Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
Example 2:

Input: board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit 1-9 or '.'.
*/
