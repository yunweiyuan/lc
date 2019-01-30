/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
 *
 * https://leetcode.com/problems/binary-tree-paths/description/
 *
 * algorithms
 * Easy (44.54%)
 * Total Accepted:    204.9K
 * Total Submissions: 459.1K
 * Testcase Example:  '[1,2,3,null,5]'
 *
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * 
 * Input:
 * 
 * ⁠  1
 * ⁠/   \
 * 2     3
 * ⁠\
 * ⁠ 5
 * 
 * Output: ["1->2->5", "1->3"]
 * 
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<String>();
	if (root == null) {
		return result;
	}

	List<String> leftPaths = binaryTreePaths(root.left);
	List<String> rightPaths = binaryTreePaths(root.right);
	for (String path : leftPaths) {
		result.add(root.val + "->" + path);
	}
	for (String path : rightPaths) {
		result.add(root.val + "->" + path);
	}

	if (result.size() == 0) {
		result.add("" + root.val);
	}

	return result;
    }
}
