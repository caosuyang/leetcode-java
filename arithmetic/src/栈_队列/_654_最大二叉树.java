package 栈_队列;
import common.TreeNode;

/**
 * https://leetcode-cn.com/problems/maximum-binary-tree/
 * @author csy
 *
 */
public class _654_最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
    	if (nums == null) return null;
    	return findRoot(nums, 0, nums.length);
    }
    
    /**
     * 找出[l, r)范围的根节点
     * @param nums
     * @param l
     * @param r
     * @return
     */
    private TreeNode findRoot(int[] nums, int l, int r) {
		if (l == r) return null;
		
		// 找出[l, r)范围内最大值的索引
		int maxIdx = l;
		for (int i = l + 1; i < r; i++) {
			if (nums[i] > nums[maxIdx]) maxIdx = i;
		}
		
		TreeNode root = new TreeNode(nums[maxIdx]);
		root.left = findRoot(nums, l, maxIdx);
		root.right = findRoot(nums, maxIdx + 1, r);
		return root;
	}
}
