package 排序_数组;

/**
 * https://leetcode-cn.com/problems/sort-colors/
 * @author myfolders
 *
 */
public class _75_颜色分类 {
	/*
	 * 你可以不使用代码库中的排序函数来解决这道题吗？
	 * 一个只包含0、1、2的整型数组，要求对它进行【原地】排序
	 * 
	 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
	 * 空间复杂度O(1)，时间复杂度O(n)
	 */
    public void sortColors(int[] nums) {
    	int i = 0;
    	int l = 0;
    	int r = nums.length - 1;
    	while (r >= i) {
    		int v = nums[i];
    		if (v == 1) {
    			i++;
    		} else if (v == 0) {
    			swap(nums, i++, l++);
    		} else { // v == 2
    			swap(nums, i, r--);
    		}
    	}
    }
    
    public void swap(int[] nums, int i, int j) {
    	int tmp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = tmp;
    }
}
