/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 *
 * https://leetcode.com/problems/longest-valid-parentheses/description/
 *
 * algorithms
 * Hard (24.66%)
 * Total Accepted:    178.3K
 * Total Submissions: 710.7K
 * Testcase Example:  '"(()"'
 *
 * Given a string containing just the characters '(' and ')', find the length
 * of the longest valid (well-formed) parentheses substring.
 * 
 * Example 1:
 * 
 * 
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 * 
 * 
 */
/* 2d dp
class Solution {
    public int longestValidParentheses(String s) {
	int result = 0;
	int len = s.length();
	int[][] subcases = new int[len][len];
	for (int i = len - 1; i >= 1; i--) {
	    for (int j = i - 1; j >= 0; j--) {
		if (s.charAt(j) == '(' && s.charAt(i) == ')') {
		    if (i == (j + 1)) {
			subcases[i][j] = 2;
			result = Math.max(result, 2);
		    }
		    for (int k = j + 1; k < i; k++) {
			
			if (Math.min(subcases[j][k], subcases[k][i]) > 0) {
			    subcases[i][j] = j - i + 1;
			    result = Math.max(result, j - i + 1);
			}	    
		    }
		}
	    }
	}
	return result;
    }
}
*/
class Solution {
    public int longestValidParentheses(String s) {
	int max = 0;
	int[] dp = new int[s.length() + 1];
	for (int i = 1; i < dp.length; i++) {
	    int j = i - 2 - dp[i-1];
	    if (s.charAt(i - 1) == '(' || j < 0 || s.charAt(j) == ')') {
		dp[i] = 0;
	    } else {
		dp[i] = dp[i - 1] + 2 + dp[j];
		max = Math.max(dp[i], max);
	    }
	}
	return max;
    }
}
