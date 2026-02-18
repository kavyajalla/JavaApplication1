package Easy;
//Junior,Math, Binary search
public class ArrangingCoins {
    public int arrangeCoins(int n) {
        int rows = 1;
        while(n>=rows) {
            n = n-rows;
            rows++;
        }
        return rows-1;
    }
}
//ChhatGPT solution
/*
 * class Solution {
    public int arrangeCoins(int n) {
        return (int)((Math.sqrt(8L*n + 1) - 1) / 2);
    }
}
 */
/**
441. Arranging Coins
Solved
Easy
Topics
premium lock icon
Companies
You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.

Given the integer n, return the number of complete rows of the staircase you will build.

 

Example 1:


Input: n = 5
Output: 2
Explanation: Because the 3rd row is incomplete, we return 2.
Example 2:


Input: n = 8
Output: 3
Explanation: Because the 4th row is incomplete, we return 3.
 

Constraints:

1 <= n <= 231 - 1
*/