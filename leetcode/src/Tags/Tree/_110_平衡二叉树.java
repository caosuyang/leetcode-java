package Tags.Tree;

import javax.xml.soap.Node;

import common.TreeNode;

/**
 * https://leetcode.cn/problems/balanced-binary-tree/
 * @author csy
 *
 */
public class _110_平衡二叉树 {
	/**
	 * 递归，深度优先搜索，自顶向下的递归，类似二叉树前序遍历
	 * 时间复杂度：O(n^2)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
    public boolean isBalanced(TreeNode root) {
    	if (root == null) {
			return true;
		}
    	// 每个node左右两棵子树高度差的绝对值<=1
    	boolean res = Math.abs(height(root.left) - height(root.right)) <= 1;
    	boolean isLeftBalance = isBalanced(root.left);
    	boolean isRightBalance = isBalanced(root.right);
    	return res && isLeftBalance && isRightBalance;
    }
    
    public int height(TreeNode node) {
    	if (node == null) {
			return 0;
		}
    	return Math.max(height(node.left), height(node.right)) + 1;
    }
    
	/**
	 * 递归，深度优先搜索，自底向上的递归，类似二叉树后序遍历
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param root
	 * @return
	 */
    public boolean isBalanced1(TreeNode root) {
    	return height1(root) >= 0;
    }
    
    public int height1(TreeNode node) {
    	if (node == null) {
			return 0;
		}
    	int leftHeight = height1(node.left);
    	int rightHeight = height1(node.right);
    	boolean res = Math.abs(leftHeight - rightHeight) > 1;
    	if (res || leftHeight == -1 || rightHeight == -1) {
    		return -1;
    	} else {
    		return Math.max(leftHeight, rightHeight) + 1;
		}
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */