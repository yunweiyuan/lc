/*
 * @lc app=leetcode id=424 lang=java
 *
 * [424] Longest Repeating Character Replacement
 *
 * https://leetcode.com/problems/longest-repeating-character-replacement/description/
 *
 * algorithms
 * Medium (43.43%)
 * Total Accepted:    28.8K
 * Total Submissions: 65.6K
 * Testcase Example:  '"ABAB"\n2'
 *
 * Given a string that consists of only uppercase English letters, you can
 * replace any letter in the string with another letter at most k times. Find
 * the length of a longest substring containing all repeating letters you can
 * get after performing the above operations.
 * 
 * Note:
 * Both the string's length and k will not exceed 10^4.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input:
 * s = "ABAB", k = 2
 * 
 * Output:
 * 4
 * 
 * Explanation:
 * Replace the two 'A's with two 'B's or vice versa.
 * 
 * 
 * 
 * 
 * Example 2:
 * 
 * Input:
 * s = "AABABBA", k = 1
 * 
 * Output:
 * 4
 * 
 * Explanation:
 * Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * 
 * 
 */
class Solution {
    public int characterReplacement(String s, int k) {
	int length = s.length();
	int maxOccuranceCount = 0, maxSubstringLength = 0;
	int[] occuranceCounts = new int[26];
	int right = 0, left = 0;
	for (right = 0; right < length; right++) {
	    maxOccuranceCount = Math.max(maxOccuranceCount,
				    ++occuranceCounts[s.charAt(right) - 'A']);
	    while (right - left + 1 - maxOccuranceCount > k) {
		occuranceCounts[s.charAt(left) - 'A']--;
		left++;
	    }
	    maxSubstringLength = Math.max(maxSubstringLength,
				    right - left + 1);
	}
	return maxSubstringLength;
    }
}
