/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
 *
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 *
 * algorithms
 * Medium (25.04%)
 * Total Accepted:    345.7K
 * Total Submissions: 1.4M
 * Testcase Example:  '[2,1,3]'
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * 
 * The left subtree of a node contains only nodes with keys less than the
 * node's key.
 * The right subtree of a node contains only nodes with keys greater than the
 * node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * ⁠   2
 * ⁠  / \
 * ⁠ 1   3
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * ⁠   5
 * ⁠  / \
 * ⁠ 1   4
 * / \
 * 3   6
 * Output: false
 * Explanation: The input is: [5,1,4,null,null,3,6]. The root node's
 * value
 * is 5 but its right child's value is 4.
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

class ResultType {
	public boolean isBST;
	public TreeNode minNode, maxNode;
	public ResultType(boolean isBST) {
		this.isBST = isBST;
		this.minNode = null;
		this.maxNode = null;
	}
}

class Solution {
    public boolean isValidBST(TreeNode root) {
    	return divideConquer(root).isBST;
    }

    private ResultType divideConquer(TreeNode root) {
	if (root == null) {
		return new ResultType(true);
	}

	ResultType left = divideConquer(root.left);
	ResultType right = divideConquer(root.right);
	
	if (!left.isBST || !right.isBST) {
		return new ResultType(false);
	}

	if (left.maxNode != null && left.maxNode.val >= root.val) {
		return new ResultType(false);
	}

	if (right.minNode != null && right.minNode.val <= root.val) {
		return new ResultType(false);
	}

	ResultType result = new ResultType(true);
	result.minNode = left.minNode != null ? left.minNode : root;
	result.maxNode = right.maxNode != null ? right.maxNode : root;

	return result;
    }
}
