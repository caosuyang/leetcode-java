package Tags.Tree;

import java.util.LinkedList;
import java.util.Queue;

import common.TreeNode;

/**
 * https://leetcode.cn/problems/invert-binary-tree/
 * @author csy
 *
 */
public class _226_翻转二叉树 {
	/**
	 * 递归+前序遍历
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * 平均空间复杂度：O(logn)
	 * 最坏空间复杂度：O(n)
	 * @param root
	 * @return
	 */
    public TreeNode invertTree(TreeNode root) {
    	if (root == null) {
			return root;
		}
    	
    	TreeNode tmp = root.left;
    	root.left = root.right;
    	root.right = tmp;
    	
    	invertTree(root.left);
    	invertTree(root.right);
    	
    	return root;
    }
    
    /**
     * 递归+中序遍历
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * 平均空间复杂度：O(logn)
     * 最坏空间复杂度：O(n)
     * @param root
     * @return
     */
    public TreeNode invertTree1(TreeNode root) {
    	if (root == null) {
			return root;
		}
    	
    	invertTree(root.left);
    	
    	TreeNode tmp = root.left;
    	root.left = root.right;
    	root.right = tmp;
    
    	invertTree(root.left);
    	
    	return root;
    }
    
    /**
     * 递归+后序遍历
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * 平均空间复杂度：O(logn)
     * 最坏空间复杂度：O(n)
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
    	if (root == null) {
			return root;
		}
    	
    	invertTree(root.left);
    	invertTree(root.right);
    	
    	TreeNode tmp = root.left;
    	root.left = root.right;
    	root.right = tmp;
    	
    	return root;
    }
    
    /**
     * 迭代+队列+层序遍历
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root
     * @return
     */
    public TreeNode invertTree3(TreeNode root) {
    	if (root == null) {
			return root;
		}
    	
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.offer(root);
    	
    	while (!queue.isEmpty()) {
			TreeNode p = queue.poll();
	    	TreeNode tmp = p.left;
	    	p.left = p.right;
	    	p.right = tmp;
	    	// 1.如果从queue出队的node的left不为空
	    	if (p.left != null) {
				queue.offer(p.left);
			}
	    	// 2.如果从queue出队的node的right不为空
	    	if (p.right != null) {
	    		queue.offer(p.right);
			}
		}
    	return root;
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
//public class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode() {}
//    TreeNode(int val) { this.val = val; }
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}