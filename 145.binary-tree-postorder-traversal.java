/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-postorder-traversal/description/
 *
 * algorithms
 * Hard (46.20%)
 * Total Accepted:    228.4K
 * Total Submissions: 493.6K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * 
 * Example:
 * 
 * 
 * Input: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * Output: [3,2,1]
 * 
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
	List<Integer> postorder = new LinkedList<>();
	
	if (root == null) {
		return postorder;
	}

	stack.push(root);
	while (!stack.isEmpty()) {
		TreeNode curNode = stack.pop();

		if (curNode.left == null && curNode.right == null) {
			postorder.add(curNode.val);
		} else {
			TreeNode rightChild = curNode.right;
			TreeNode leftChild = curNode.left;
			curNode.left = null;
			curNode.right = null;
			
			stack.push(curNode);
			if (rightChild != null) {
				stack.push(rightChild);
			}
			if (leftChild != null) {
				stack.push(leftChild);
			}
		}
	}
	return postorder;
    }
}
