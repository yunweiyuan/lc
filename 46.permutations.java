/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 *
 * https://leetcode.com/problems/permutations/description/
 *
 * algorithms
 * Medium (52.38%)
 * Total Accepted:    322K
 * Total Submissions: 613.9K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a collection of distinct integers, return all possible permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,2,3]
 * Output:
 * [
 * ⁠ [1,2,3],
 * ⁠ [1,3,2],
 * ⁠ [2,1,3],
 * ⁠ [2,3,1],
 * ⁠ [3,1,2],
 * ⁠ [3,2,1]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
       	 List<List<Integer>> result = new ArrayList<>();
	 if (nums == null && nums.length == 0) {
		 return result;
	 }
	 boolean[] visited = new boolean[nums.length];
	 helper(nums, new ArrayList<Integer>(), result, visited);
	 return result;
    }

    private void helper(int[] nums,
			List<Integer> subset,
			List<List<Integer>> result,
			boolean[] visited) {
			if (subset.size() == nums.length) {
				result.add(new ArrayList<Integer>(subset));
				return;
			}

			for (int i = 0; i < nums.length; i++) {
				if (visited[i]) {
					continue;
				}
				if (!visited[i]) {
					subset.add(nums[i]);
					visited[i] = true;
				}
				helper(nums, subset, result, visited);
				subset.remove(subset.size() - 1);
				visited[i] = false;
			}
    }
}
