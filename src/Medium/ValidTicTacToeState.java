package Medium;

public class ValidTicTacToeState {
	 public boolean validTicTacToe(String[] board) {
	        int x = 0;
	        int o = 0;
	        char[][] b = new char[3][3];
	        for(int i=0; i< board.length; i++)
	        {
	            char[] c = board[i].toCharArray();
	            for(int j=0; j<c.length; j++ )
	            {
	                b[i][j] = c[j];

	                if(c[j] == 'X')
	                {
	                    x++;
	                }
	                else if(c[j] == 'O')
	                {
	                    o++;
	                }
	                else if(c[j] == ' ')
	                {
	                }
	                else
	                {
	                    return false;
	                }
	            }
	        }

	        if(x < o)
	        {
	            return false;
	        }

	        if(x > o+1)
	        {
	            return false;
	        }

	        if(winner('X', b) && winner('O', b))
	        {
	            return false;
	        }

	        if(winner('X', b))
	        {
	            if(x == o)
	            {
	                return false;
	            }
	        }

	        if(winner('O', b))
	        {
	            if(o != x)
	            {
	                return false;
	            }
	        }

	        return true;
	    }

	    private boolean winner(char player, char[][] b)
	    {
	        if(
	        (b[0][0] == player && b[0][1] == player && b[0][2] == player) || //row 1
	        (b[1][0] == player && b[1][1] == player && b[1][2] == player) || //row 2
	        (b[2][0] == player && b[2][1] == player && b[2][2] == player) || //row 3
	        (b[0][0] == player && b[1][1] == player && b[2][2] == player) || //dia 1
	        (b[2][0] == player && b[1][1] == player && b[0][2] == player) || //dia 2
	        (b[0][0] == player && b[1][0] == player && b[2][0] == player) || //col 1
	        (b[0][1] == player && b[1][1] == player && b[2][1] == player) || //col 2
	        (b[0][2] == player && b[1][2] == player && b[2][2] == player)) //col 3
	        {
	            return true;
	        }
	        return false;
	    }
}
/**
794. Valid Tic-Tac-Toe State
Solved
Medium
Topics
premium lock icon
Companies
Given a Tic-Tac-Toe board as a string array board, return true if and only if it is possible to reach this board position during the course of a valid tic-tac-toe game.

The board is a 3 x 3 array that consists of characters ' ', 'X', and 'O'. The ' ' character represents an empty square.

Here are the rules of Tic-Tac-Toe:

Players take turns placing characters into empty squares ' '.
The first player always places 'X' characters, while the second player always places 'O' characters.
'X' and 'O' characters are always placed into empty squares, never filled ones.
The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
The game also ends if all squares are non-empty.
No more moves can be played if the game is over.
 

Example 1:


Input: board = ["O  ","   ","   "]
Output: false
Explanation: The first player always plays "X".
Example 2:


Input: board = ["XOX"," X ","   "]
Output: false
Explanation: Players take turns making moves.
Example 3:


Input: board = ["XOX","O O","XOX"]
Output: true
 

Constraints:

board.length == 3
board[i].length == 3
board[i][j] is either 'X', 'O', or ' '.
*/