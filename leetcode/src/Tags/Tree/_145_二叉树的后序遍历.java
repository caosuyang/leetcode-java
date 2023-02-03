package Tags.Tree;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;
/**
 * https://leetcode.cn/problems/binary-tree-postorder-traversal/
 * @author csy
 *
 */
public class _145_二叉树的后序遍历 {
	private List<Integer> list = new ArrayList<>();
	
	/**
	 * 递归，后序遍历，深度优先搜索
	 * 时间复杂度：O(n)，其中 n 为二叉树的节点个数
	 * 空间复杂度：O(n)，其中 n 为递归过程中栈的开销
	 * 平均情况下为 O(log⁡n)，最坏情况下树呈现链状，为 O(n)
	 * @param root
	 * @return
	 */
    public List<Integer> postorderTraversal(TreeNode root) {
    	if (root == null) {
			return list;
		}
    	postorderTraversal(root.left);
    	postorderTraversal(root.right);
    	list.add(root.val);
    	return list;
    }
    
	/**
	 * 迭代，栈，后序遍历，深度优先搜索
	 * 时间复杂度：O(n)，其中 n 为二叉树的节点个数
	 * 空间复杂度：O(n)，其中 n 为迭代过程中显式栈的开销
	 * 平均情况下为 O(log⁡n)，最坏情况下树呈现链状，为 O(n)
	 * @param root
	 * @return
	 */
    public List<Integer> postorderTraversal1(TreeNode root) {
    	List<Integer> list = new ArrayList<>();
    	if (root == null) {
			return list;
		}
    	Stack<TreeNode> stack = new Stack<>();
    	// 1. 将 root 入栈
    	stack.push(root);
    	// 上一次访问的节点
    	TreeNode last = null;
    	// 2. 循环执行以下操作，直到栈为空
    	while (!stack.isEmpty()) {
    		TreeNode p = stack.peek();
			// 如果栈顶节点是叶子节点 或者 上一次访问的节点是栈顶节点的子节点
    		// 重要：last != null
    		boolean isLeaf = p.left == null && p.right == null;
    		boolean isChild = last != null && (last == p.left || last == p.right);
			if (isLeaf || isChild) {
	    		// 弹出栈顶节点 top，进行访问
				TreeNode top = stack.pop();
				list.add(top.val);
				last = top;
			} else {
				// 否则，将栈顶节点的right、left按顺序入栈
				stack.push(p.right);
				stack.push(p.left);
			}
		}
    	return list;
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