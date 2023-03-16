package Tags.Tree;

import java.util.LinkedList;
import java.util.Queue;

import common.TreeNode;

/**
 * https://leetcode.cn/problems/er-cha-shu-de-shen-du-lcof/
 * @author csy
 *
 */
public class _剑指Offer55_I_二叉树的深度 {
	/**
	 * 递归，深度优先搜索
	 * 时间复杂度：O(n)，其中 n 为二叉树的节点个数
	 * 空间复杂度：O(height)，其中 height 表示二叉树的高度
	 * @param root
	 * @return
	 */
    public int maxDepth(TreeNode root) {
    	if (root == null) {
			return 0;
		}
    	int leftDeep = maxDepth(root.left);
    	int rightDeep = maxDepth(root.right);
    	return Math.max(leftDeep, rightDeep) + 1;
    }
    
    /**
     * 迭代，队列，层序遍历，广度优先搜索
     * 时间复杂度：O(n)，其中 n 为二叉树的节点个数
     * 空间复杂度：O(n)，其中 n 为队列存储的元素数量
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
    	if (root == null) {
			return 0;
		}
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.offer(root);
    	int deep = 0;
    	while (!queue.isEmpty()) {
    		int size = queue.size();
			
			while (size-- > 0) {
				TreeNode p = queue.poll();
				// 1.如果从queue出队的node的left不为空
				if (p.left != null) {
					queue.offer(p.left);
				}
				// 2.如果从queue出队的node的right不为空
				if (p.right != null) {
					queue.offer(p.right);
				}
			}
			deep++;
		}
    	return deep;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */