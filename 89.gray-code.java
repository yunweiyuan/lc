/*
 * @lc app=leetcode id=89 lang=java
 *
 * [89] Gray Code
 *
 * https://leetcode.com/problems/gray-code/description/
 *
 * algorithms
 * Medium (44.59%)
 * Total Accepted:    128.1K
 * Total Submissions: 284.1K
 * Testcase Example:  '2'
 *
 * The gray code is a binary numeral system where two successive values differ
 * in only one bit.
 * 
 * Given a non-negative integer n representing the total number of bits in the
 * code, print the sequence of gray code. A gray code sequence must begin with
 * 0.
 * 
 * Example 1:
 * 
 * 
 * Input: 2
 * Output: [0,1,3,2]
 * Explanation:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * 
 * For a given n, a gray code sequence may not be uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence.
 * 
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 0
 * Output: [0]
 * Explanation: We define the gray code sequence to begin with 0.
 * A gray code sequence of n has size = 2^n, which for n = 0 the size is 2^0 =
 * 1.
 * Therefore, for n = 0 the gray code sequence is [0].
 * 
 * 
 */
class Solution {
    public List<Integer> grayCode(int n) {
        if (n == 0) {
	    return Arrays.asList(0);
	}

	List<Integer> result = new ArrayList<Integer>();
	List<Integer> formers = grayCode(n - 1);
	int addition = (int)Math.pow(2, n - 1);
	for (int num : formers) {
            result.add(num);
	}
	for (int i = formers.size() - 1; i >= 0; i-- ) {
            result.add(formers.get(i) + addition);
	}
	return result;
    }
}
