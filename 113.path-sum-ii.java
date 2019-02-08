/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
 *
 * https://leetcode.com/problems/path-sum-ii/description/
 *
 * algorithms
 * Medium (38.92%)
 * Total Accepted:    207.9K
 * Total Submissions: 532.8K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,5,1]\n22'
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given the below binary tree and sum = 22,
 * 
 * 
 * ⁠     5
 * ⁠    / \
 * ⁠   4   8
 * ⁠  /   / \
 * ⁠ 11  13  4
 * ⁠/  \    / \
 * 7    2  5   1
 * 
 * 
 * Return:
 * 
 * 
 * [
 * ⁠  [5,4,11,2],
 * ⁠  [5,8,4,5]
 * ]
 * 
 * 
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
	if (root == null) {
		return paths;
	}
	ArrayList<Integer> path = new ArrayList<Integer>();
	path.add(root.val);
	dfs(root, sum - root.val, path, paths);
	return paths;
    }

    private void dfs(TreeNode root,
		    	       int sum,
			       List<Integer> path,
			       List<List<Integer>> paths) {
	if (root.left == null && root.right == null && sum == 0) {
		paths.add(new ArrayList<Integer>(path));
	}
	
	if (root.left != null) {
		path.add(root.left.val);
		dfs(root.left, sum - root.left.val, path, paths);
		path.remove(path.size() - 1);
	}

	if (root.right != null) {
		path.add(root.right.val);
		dfs(root.right, sum - root.right.val, path, paths);
		path.remove(path.size() - 1);
	}
    }
}
