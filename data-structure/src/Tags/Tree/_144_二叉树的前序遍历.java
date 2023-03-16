package Tags.Tree;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;
/**
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/
 * @author csy
 *
 */
public class _144_二叉树的前序遍历 {
	private List<Integer> list = new ArrayList<>();
	
	/**
	 * 递归，前序遍历，深度优先搜索
	 * 时间复杂度：O(n)，其中 n 为二叉树的节点个数
	 * 空间复杂度：O(n)，其中 n 为递归过程中栈的开销
	 * 平均情况下为 O(log⁡n)，最坏情况下树呈现链状，为 O(n)
	 * @param root
	 * @return
	 */
    public List<Integer> preorderTraversal(TreeNode root) {
    	if (root == null) {
			return list;
		}
    	list.add(root.val);
    	preorderTraversal(root.left);
    	preorderTraversal(root.right);
    	return list;
    }
    
	/**
	 * 迭代，栈，前序遍历，深度优先搜索
	 * 时间复杂度：O(n)，其中 n 为二叉树的节点个数
	 * 空间复杂度：O(n)，其中 n 为迭代过程中显式栈的开销
	 * 平均情况下为 O(log⁡n)，最坏情况下树呈现链状，为 O(n)
	 * @param root
	 * @return
	 */
    public List<Integer> preorderTraversal1(TreeNode root) {
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
        		// 对 node 进行访问
        		list.add(node.val);
        		// 将 node.right 入栈
        		if (node.right != null) {
        			stack.push(node.right);
				}
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
                    // 重要：一直pop到stack顶部是非空节点，此时note不为空，跳到while1条件
    				node = stack.pop();
    			}
			}
		}
    }
    
	/**
	 * 非递归，栈，优化，前序遍历，深度优先搜索
	 * 时间复杂度：O(n)，其中 n 为二叉树的节点个数
	 * 空间复杂度：O(n)，其中 n 为迭代过程中显式栈的开销
	 * 平均情况下为 O(log⁡n)，最坏情况下树呈现链状，为 O(n)
	 * @param root
	 * @return
	 */
    public List<Integer> preorderTraversal2(TreeNode root) {
    	List<Integer> list = new ArrayList<>();
    	if (root == null) {
			return list;
		}
    	Stack<TreeNode> stack = new Stack<>();
    	// 1. 将 root 入栈
    	stack.push(root);
    	// 2. 循环执行以下操作，直到栈为空
    	while (!stack.isEmpty()) {
    		// 弹出栈顶节点 top，进行访问
			TreeNode top = stack.pop();
			list.add(top.val);
			// 重要：先right后left，因为stack是后进先出
			// 将 top.right 入栈
			if (top.right != null) {
				stack.push(top.right);
			}
			// 将 top.left 入栈
			if (top.left != null) {
				stack.push(top.left);
			}
		}
    	return list;
    }
    
	/**
	 * 迭代，栈，前序遍历，深度优先搜索，优化
	 * 时间复杂度：O(n)，其中 n 为二叉树的节点个数
	 * 空间复杂度：O(n)，其中 n 为迭代过程中显式栈的开销
	 * 平均情况下为 O(log⁡n)，最坏情况下树呈现链状，为 O(n)
	 * @param root
	 * @return
	 */
    public List<Integer> preorderTraversal3(TreeNode root) {
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
        		// 对 node 进行访问
        		list.add(node.val);
        		// 将 node.right 入栈
        		if (node.right != null) {
        			stack.push(node.right);
				}
        		// 设置 node = node.left
        		node = node.left;
    		} else if (stack.isEmpty()) { // 如果 node == null
    			// 如果栈为空，结束遍历
	    		return list;
			} else {
				// 如果栈不为空，弹出栈顶元素并赋值给 node
                // 重要：一直pop到stack顶部是非空节点，此时note不为空，跳到while1条件
				node = stack.pop();
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