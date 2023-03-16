package Tags.Tree;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;
/**
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/description/
 * @author csy
 *
 */
public class _94_二叉树的中序遍历 {
	private List<Integer> list = new ArrayList<>();
	
	/**
	 * 递归，中序遍历，深度优先搜索
	 * 时间复杂度：O(n)，其中 n 为二叉树的节点个数
	 * 空间复杂度：O(n)，其中 n 为递归过程中栈的开销
	 * 平均情况下为 O(log⁡n)，最坏情况下树呈现链状，为 O(n)
	 * @param root
	 * @return
	 */
    public List<Integer> inorderTraversal(TreeNode root) {
    	if (root == null) {
			return list;
		}
    	inorderTraversal(root.left);
    	list.add(root.val);
    	inorderTraversal(root.right);
    	return list;
    }
    
	/**
	 * 迭代，栈，中序遍历，深度优先搜索
	 * 时间复杂度：O(n)，其中 n 为二叉树的节点个数
	 * 空间复杂度：O(n)，其中 n 为迭代过程中显式栈的开销
	 * 平均情况下为 O(log⁡n)，最坏情况下树呈现链状，为 O(n)
	 * @param root
	 * @return
	 */
    public List<Integer> inorderTraversal1(TreeNode root) {
    	List<Integer> list = new ArrayList<>();
    	if (root == null) {
			return list;
		}
    	Stack<TreeNode> stack = new Stack<>();
    	// 1. 设置 node = root
    	TreeNode node = root;
    	// 2. 循环执行以下操作
    	while (true) {
    		// while1：如果 node != null
        	while (node != null) {
        		// 将 node 入栈
        		stack.push(node);
        		// 设置 node = node.left
        		node = node.left;
    		} 
        	// while2：如果 node == null
        	while (node == null) {
    			// 如果栈为空，结束遍历
    	    	if (stack.isEmpty()) {
    	    		return list;
    			} else {
    				// 如果栈不为空，弹出栈顶元素并赋值给 node
    				node = stack.pop();
            		// 对 node 进行访问
            		list.add(node.val);
            		// 设置 node = node.right
            		// 重要：node不为空时跳到while1条件
            		node = node.right;
    			}
			}
		}
    }
    
	/**
	 * 迭代，栈，中序遍历，深度优先搜索，优化
	 * 时间复杂度：O(n)，其中 n 为二叉树的节点个数
	 * 空间复杂度：O(n)，其中 n 为迭代过程中显式栈的开销
	 * 平均情况下为 O(log⁡n)，最坏情况下树呈现链状，为 O(n)
	 * @param root
	 * @return
	 */
    public List<Integer> inorderTraversal2(TreeNode root) {
    	List<Integer> list = new ArrayList<>();
    	if (root == null) {
			return list;
		}
    	Stack<TreeNode> stack = new Stack<>();
    	// 1. 设置 node = root
    	TreeNode node = root;
    	// 2. 循环执行以下操作
    	while (true) {
    		// 如果 node != null
        	if (node != null) {
        		// 将 node 入栈
        		stack.push(node);
        		// 设置 node = node.left
        		node = node.left;
    		} else if (stack.isEmpty()) {
        		// 如果栈为空，结束遍历
    			return list;
			} else {
				// 如果栈不为空，弹出栈顶元素并赋值给 node
				node = stack.pop();
        		// 对 node 进行访问
        		list.add(node.val);
        		// 设置 node = node.right
        		// 重要：node不为空时跳到while1条件
        		node = node.right;
			}
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