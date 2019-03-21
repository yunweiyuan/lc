/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 *
 * https://leetcode.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (52.37%)
 * Total Accepted:    309.7K
 * Total Submissions: 578.3K
 * Testcase Example:  '3'
 *
 * 
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * 
 * 
 * For example, given n = 3, a solution set is:
 * 
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
	generate(result, "", 0, 0, n);
	return result;
    }

    private void generate(List<String> result, String cur, int open,
		    int close, int pair_count) {
        if (cur.length() == 2 * pair_count) {
            result.add(cur);
	}

	if (open < pair_count) {
            generate(result, cur + "(", open + 1, close, pair_count);
	}
	if (close < open) {
            generate(result, cur + ")", open, close + 1, pair_count);
	}
    }
}
