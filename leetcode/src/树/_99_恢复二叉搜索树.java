package 树;
import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 * @author csy
 *
 */
public class _99_恢复二叉搜索树 {
	// 上一次中序遍历过的节点
	private TreeNode prev;
	// 第一个错误节点
	private TreeNode first;
	// 第二个错误节点
	private TreeNode second;
	
    public void recoverTree(TreeNode root) {
    	TreeNode node = root;
    	while (node != null) {
    		if (node.left != null) {
    			// 找到前驱节点(predecessor)、后继节点(successor)
    			TreeNode pred = node.left;
                while (pred.right != null && pred.right != node) {
                    pred = pred.right;
                }
                
                if (pred.right == null) {
                    pred.right = node;
                    node = node.left;
                } else { // pred.right == node
                    find(node);
                    pred.right = null;
                    node = node.right;
                }
    		} else {
                find(node);
                node = node.right;
			}
		}
    	
        // 交换2个错误节点的值
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
    
    public void find(TreeNode node) {
		// 出现了逆序对
    	if (prev != null && prev.val > node.val) {
    		// 第2个错误节点：最后一个逆序对中较小的那个节点
    		second = node;
    		
    		// 第1个错误节点：第一个逆序对中较大的那个节点
    		if (first != null) return;
    		first = prev;
		}
    	prev = node;
	}
}
