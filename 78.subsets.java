/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 *
 * https://leetcode.com/problems/subsets/description/
 *
 * algorithms
 * Medium (49.91%)
 * Total Accepted:    313.2K
 * Total Submissions: 627.5K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: nums = [1,2,3]
 * Output:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 */
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
	List<List<Integer>> result = new ArrayList<>();
	if (nums == null || nums.length == 0) {
		return result;
	}

	helper(nums, 0, new ArrayList<Integer>(), result);
	return result;	
    }

    private void helper(int[] nums, int startIdx, List<Integer> subset, List<List<Integer>> result) {
	result.add(new ArrayList<Integer>(subset));

	for(int i = startIdx; i < nums.length; i++) {
		subset.add(nums[i]);
		helper(nums, i + 1, subset, result);
		subset.remove(subset.size() - 1);
	}	
    }
}
