/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 *
 * https://leetcode.com/problems/subsets-ii/description/
 *
 * algorithms
 * Medium (40.91%)
 * Total Accepted:    181.8K
 * Total Submissions: 444.1K
 * Testcase Example:  '[1,2,2]'
 *
 * Given a collection of integers that might contain duplicates, nums, return
 * all possible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
a
set number
 * Input: [1,2,2]
 * Output:
 * [
 * ⁠ [2],
 * ⁠ [1],
 * ⁠ [1,2,2],
 * ⁠ [2,2],
 * ⁠ [1,2],
 * ⁠ []
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
      	List<List<Integer>> result = new ArrayList<>();
      	if (nums == null || nums.length == 0) {
		return result;
      	}
	Arrays.sort(nums);
	helper(nums, 0, new ArrayList<Integer>(), result);
	return result;
    }

    void helper(int[] nums, int startIdx, List<Integer> subset, List<List<Integer>> result) {
	result.add(new ArrayList<>(subset));

	for (int i = startIdx; i < nums.length; i++) {
		if (i > startIdx && nums[i] == nums[i - 1]) {
			continue;
		}
		subset.add(nums[i]);
		helper(nums, i + 1, subset, result);
		subset.remove(subset.size() - 1);
	}
    }
}
