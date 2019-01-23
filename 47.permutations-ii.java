/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 *
 * https://leetcode.com/problems/permutations-ii/description/
 *
 * algorithms
 * Medium (38.44%)
 * Total Accepted:    212.6K
 * Total Submissions: 551.6K
 * Testcase Example:  '[1,1,2]'
 *
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * Example:
 * 
 * 
 * Input: [1,1,2]
 * Output:
 * [
 * ⁠ [1,1,2],
 * ⁠ [1,2,1],
 * ⁠ [2,1,1]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
      	List<List<Integer>> result = new ArrayList<>();
      	if (nums == null || nums.length == 0) {
	       return result;
	}
	Arrays.sort(nums);
	boolean[] visited = new boolean[nums.length];
	helper(nums, new ArrayList<Integer>(), result, visited);
	return result;	
    }

    private void helper(int[] nums,
		   List<Integer> subset,
		   List<List<Integer>> result,
		   boolean[] visited) {
	if (subset.size() == nums.length) {
		result.add(new ArrayList<>(subset));
		return;
	}

	for (int i = 0; i < nums.length; i++) {
		if (visited[i] ||
		    (i > 0 && nums[i] == nums[i - 1] &&
		     !visited[i - 1] && !visited[i])) {
			continue;
		}
		subset.add(nums[i]);
		visited[i] = true;
		helper(nums, subset, result, visited);
		visited[i] = false;
		subset.remove(subset.size() - 1);
	}
    }
}
