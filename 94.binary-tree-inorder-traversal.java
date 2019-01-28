/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
 *
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Medium (54.30%)
 * Total Accepted:    392.2K
 * Total Submissions: 721.4K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * Example:
 * 
 * 
 * Input: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * Output: [1,3,2]
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

// succeeded
/*
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
	List<Integer> inorder = new LinkedList<>();

	if (root == null) {
		return inorder;
	}

	stack.push(root);
	while (!stack.isEmpty()) {
		TreeNode curNode = stack.pop();

		if (curNode.left == null && curNode.right == null) {
			inorder.add(curNode.val);
		} else {
			if (curNode.right != null) {
				stack.push(curNode.right);
				curNode.right = null;
			}
		
			TreeNode temp = curNode.left;
			curNode.left = null;
			stack.push(curNode);
			if (temp != null) {
				stack.push(temp);
			}
		}
	}
	return inorder;
    }
}
*/

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
	Stack<TreeNode> stack = new Stack<>();
	List<Integer> inorder = new LinkedList<>();

	TreeNode curNode = root;
	while (curNode != null || !stack.isEmpty()) {
	    while (curNode != null) {
		stack.push(curNode);
		curNode = curNode.left;
	    }

	    curNode = stack.pop();
	    inorder.add(curNode.val);
	    curNode = curNode.right;
	}
	return inorder;
    }
}
