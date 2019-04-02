/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 *
 * https://leetcode.com/problems/minimum-window-substring/description/
 *
 * algorithms
 * Hard (29.44%)
 * Total Accepted:    221.1K
 * Total Submissions: 732K
 * Testcase Example:  '"ADOBECODEBANC"\n"ABC"'
 *
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * Example:
 * 
 * 
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * 
 * 
 * Note:
 * 
 * 
 * If there is no such window in S that covers all characters in T, return the
 * empty string "".
 * If there is such window, you are guaranteed that there will always be only
 * one unique minimum window in S.
 * 
 */
class Solution {
    public String minWindow(String s, String t) {
	Map<Character, Integer> occuranceRecorder =
					    new HashMap<Character, Integer>();
	for (char letter : t.toCharArray()) {
	   if (occuranceRecorder.containsKey(letter)) {
		occuranceRecorder.put(letter, occuranceRecorder.get(letter) + 1);
	   } else {
		occuranceRecorder.put(letter, 1);
	   }
	}
	int remainingTargets = occuranceRecorder.size();
	int begin = 0, left = 0, windowSize = Integer.MAX_VALUE;
	for (int i = 0; i < s.length(); i++) {
	    if (occuranceRecorder.containsKey(s.charAt(i))) {
		int letterCount = occuranceRecorder.get(s.charAt(i));
		if (letterCount - 1 == 0) {
		    remainingTargets--;
		}
		occuranceRecorder.put(s.charAt(i), letterCount - 1);
	    }
	    while (remainingTargets == 0) {
		if (windowSize > i - left + 1) {
		    windowSize = i - left + 1;
		    begin = left;
		}
		// concise the window by moving the left side forward.
		char currentLeftLetter = s.charAt(left);
		if (occuranceRecorder.containsKey(currentLeftLetter)) {
		    occuranceRecorder.put(currentLeftLetter,
			    occuranceRecorder.get(currentLeftLetter) + 1);
		    if (occuranceRecorder.get(currentLeftLetter) > 0) {
			remainingTargets++;
		    }
		}
		left++;
	    }
	}
	return windowSize == Integer.MAX_VALUE ? ""
		: s.substring(begin, begin + windowSize);
    }
}
