/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * algorithms
 * Medium (26.14%)
 * Total Accepted:    505.2K
 * Total Submissions: 1.9M
 * Testcase Example:  '"babad"'
 *
 * Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * 
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "cbbd"
 * Output: "bb"
 * 
 * 
 */
/* 1d dp, aaaaa failed
class Solution {
    public String longestPalindrome(String s) {
	int max = 1;
	int maxIndex = 0;
	int[] dp = new int[s.length() + 1];
	Arrays.fill(dp, 1);
	dp[0] = 0;
	for (int i = 1; i < dp.length; i++) {
	    int counterCharIndex = i - 2 - dp[i - 1];
	    if (counterCharIndex < 0 ||
		    s.charAt(counterCharIndex) != s.charAt(i - 1)) {
		dp[i] = (i >= 2) ?
			    (s.charAt(i - 1) == s.charAt(i - 2)) ? 2
			    : 1
			: 1;
	    } else {
		dp[i] = dp[i - 1] + 2 + dp[counterCharIndex];
	    }
	    if (dp[i] > max) {
		max = dp[i];
		maxIndex = i;
	    }
	}
	return s.substring(maxIndex - dp[maxIndex], maxIndex);
    }
}*/
class Solution {
    public String longestPalindrome(String s) {
	int length = s.length();
	int[] max = new int[2];
	int[][] dp = new int[length][length];
	for (int i = 0; i < length; i++) {
	    for (int j = i; j >= 0; j--) {
		if (i == j) {
		    dp[i][j] = 1;
		    if ((i - j) > (max[1] - max[0])) {
			max[0] = j;
			max[1] = i;
		    }
		} else if ((i == j + 1) && (s.charAt(i) == s.charAt(j))) {
		    dp[i][j] = 2;
		    if (i - j > max[1] - max[0]) {
			max[0] = j;
			max[1] = i;
		    }
		} else if ((i - j > 1) &&
			    (s.charAt(i) == s.charAt(j)) &&
			    dp[i-1][j+1] > 0){
		    dp[i][j] = 2 + dp[i-1][j+1];
		    if ((i - j) > (max[1] - max[0])) {
			max[0] = j;
			max[1] = i;
		    }
		} else {
		    continue;
		}
	    }
	}
	if (length == 0) return "";
	return s.substring(max[0], max[1] + 1);
    }
}
