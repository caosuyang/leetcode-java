package 字符串;

import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 * @author csy
 *
 */
public class _572_另一个树的子树 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    	if (root == null || subRoot == null) return false;
    	
    	return contains(postSerialize(root), postSerialize(subRoot));
    }
    
    /**
     * 利用先序遍历的方式进行序列化
     * @param root
     * @return
     */
    private String postSerialize(TreeNode root) {
    	StringBuilder sb = new StringBuilder("!");
    	postSerialize(root, sb);
    	return sb.toString();
    }
    	
    private void postSerialize(TreeNode node, StringBuilder sb) {
		sb.append(node.val).append("!");
		
		if (node.left == null) {
			sb.append("#!");
		} else {
			postSerialize(node.left, sb);
		}
			
		if (node.right == null) {
			sb.append("#!");
		} else {
			postSerialize(node.right, sb);
		}
	}
    
    /**
     * KMP算法
     * @param text
     * @param pattern
     * @return
     */
	private boolean contains(String text, String pattern) {
		int plen = pattern.length();
		int tlen = text.length();
		if (tlen == 0 || plen == 0 || tlen < plen) return false;
		int[] next = next(pattern);
		int pi = 0, ti = 0;
		int tmax = tlen - plen;
		while (pi < plen && ti - pi <= tmax) {
			if (pi < 0 || text.charAt(ti) == pattern.charAt(pi)) {
				ti++;
				pi++;
			} else {
				pi = next[pi];
			}
		}
		return pi == plen;
	}
	
	private int[] next(String pattern) {
		int len = pattern.length();
		int[] next = new int[len];
		int i = 0; 
		int n = next[i] = -1;
		int imax = len - 1;
		while (i < imax) {
			if (n < 0 || pattern.charAt(i) == pattern.charAt(n)) {
				i++;
				n++;
				if (pattern.charAt(i) == pattern.charAt(n)) {
					next[i] = next[n];
				} else {
					next[i] = n;
				}
			} else {
				n = next[n];
			}
		}
		return next;
	}
}
