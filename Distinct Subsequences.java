/*
 * Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.

Solution: DP. The idea is conditionally determine whether the char at S[i-1] and T[j-1] can be used
directly or not.

 * */
public class Solution {
    public int numDistinct(String S, String T) {
        int[][] table = new int[S.length() + 1][T.length() + 1];
 
    	for (int i = 0; i < S.length(); i++)
    		table[i][0] = 1;    // This initial condition is important, meaning empty T returns 1
     
    	for (int i = 1; i <= S.length(); i++) {
    		for (int j = 1; j <= T.length(); j++) {
    			if (S.charAt(i - 1) == T.charAt(j - 1)) {
    			    // Exclude the last char of S, or include it
    				table[i][j] = table[i - 1][j] + table[i - 1][j - 1];
    			} else {
    			    // Has to skip the last char of S
    				table[i][j] = table[i - 1][j];
    			}
    		}
    	}
     
    	return table[S.length()][T.length()];
    }
}
