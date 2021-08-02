package 排序_数组;

/**
 * https://leetcode-cn.com/problems/sub-sort-lcci/
 * @author myfolders
 *
 */
public class _面试题_16_16_部分排序 {
	/*
	 * { 1, 5, 4, 3, 2, 6, 7 }
	 */
    public int[] subSort(int[] array) {
    	// 边界判定
    	if (array.length == 0) return new int[] { -1, -1 };
    	
    	// 从左往右扫描寻找最右逆序对（正序：逐渐变大）
    	int max = array[0];
    	// 记录最右逆序对的位置
    	int r = -1;
    	for (int i = 1; i < array.length; i++) {
    		int v = array[i];
    		if (v >= max) {
    			max = v;
    		} else { // max < v
    			r = i;
    		}
    	}
    	
    	// 经过一轮扫描没有逆序对，提前结束
    	if (r == -1) return new int[] { -1, -1 };
    	
    	// 从右往左扫描寻找最左逆序对（正序：逐渐变小）
    	int min = array[array.length - 1];
    	// 记录最左逆序对的位置
    	int l = -1;
    	for (int i = array.length - 2; i >= 0; i--) {
    		int v = array[i];
    		if (v <= min) {
    			min = v;
    		} else { // min > v
    			l = i;
    		}
    	}
    	
    	return new int[] { l, r };
    }
}
