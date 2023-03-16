package com.csy.sort.cmp.selection;

/**
 * 选择排序（Selection Sort）
 * 方法一：两层遍历+减少交换次数
 * 912. 排序数组
 * https://leetcode.cn/problems/sort-an-array/
 * @author csy
 *
 */
public class SelectionSort1 {
	/**
	 * 两层遍历+减少交换次数
	 * 最坏、平均、最优时间复杂度，总是需要两层遍历 O(n^2)
	 * 空间复杂度 O(1)，没有额外堆空间和递归调用
	 * 属于稳定的排序算法，nums[max] <= nums[begin]
	 * 属于原地算法，没有依赖外部资源，只对传入参数nums进行修改和覆盖
	 * @param nums
	 * @return
	 */
    public int[] sortArray(int[] nums) {
    	for (int end = nums.length - 1; end > 0; end--) {
    		int max = 0;
        	for (int begin = 1; begin <= end; begin++) {
    			if (nums[max] <= nums[begin]) {
    				max = begin;
    			}
    		}
			int tmp = nums[max];
			nums[max] = nums[end];
			nums[end] = tmp;
		}
    	return nums;
    }
    
    /**
     * 912. 排序数组
     * 给你一个整数数组 nums，请你将该数组升序排列。
     * 示例 1：
     * 输入：nums = [5,2,3,1]
     * 输出：[1,2,3,5]
     * 示例 2：
     * 输入：nums = [5,1,1,2,0,0]
     * 输出：[0,0,1,1,2,5]
     * 提示：
     * 1 <= nums.length <= 5 * 104
     * -5 * 104 <= nums[i] <= 5 * 104
     * @param args
     * leetcode执行结果：12 / 20 个通过的测试用例，超出时间限制
     */
    public static void main(String[] args) {
//		int[] array = {7, 3, 5, 8, 6, 7, 4, 5};
//    	int[] array = {5,2,3,1};
    	int[] array = {5,1,1,2,0,0};
    	SelectionSort1 ss = new SelectionSort1();
		array = ss.sortArray(array);
		for (int i : array) {
			System.out.print(i);
		}
	}
}

///**
// * 选择排序（Selection Sort）
// * @author csy
// *
// */
//public class SelectionSort1 {
//	/**
//	 * 重复遍历，头尾指针，与末尾交换
//	 * 时间复杂度：O(n^2)
//	 * 空间复杂度：O(1)
//	 * 稳定性：不稳定
//	 * 属于原地算法
//	 * @param array
//	 * @return
//	 */
//	public int[] selectionSort(int[] array) {
//		for (int end = array.length - 1; end > 0; end--) {
//			// 从序列中找出最大元素
//			int max = 0;
//			for (int begin = 1; begin <= end; begin++) {
//				// array[max] < array[begin]
//				if (cmp(array, max, begin) < 0) {
//					max = begin;
//				}
//			}
//			// 与末尾元素交换位置
//			swap(array, max, end);
//		}// 忽略找到的最大元素，重复执行
//		return array;
//	}
//	
//	/**
//	 * 比较数组中index1和index2位置元素值的大小
//	 * 返回值等于0，代表 array[i1] == array[i2]
//	 * 返回值小于0，代表 array[i1] < array[i2]
//	 * 返回值大于0，代表 array[i1] > array[i2]
//	 * @param array
//	 * @param i1
//	 * @param i2
//	 * @return
//	 */
//	public int cmp(int[] array, int i1, int i2) {
//		return array[i1] - array[i2];
//	}
//	
//	/**
//	 * 交换数组中index1和index2位置元素的位置
//	 * @param array
//	 * @param i1
//	 * @param i2
//	 */
//	public void swap(int[] array, int i1, int i2) {
//		int tmp = array[i1];
//		array[i1] = array[i2];
//		array[i2] = tmp;
//	}
//	
//	/**
//	 * test
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		int[] array = {7, 3, 5, 8, 6, 7, 4, 5};
//		SelectionSort1 ss = new SelectionSort1();
//		array = ss.selectionSort(array);
//		for (int i : array) {
//			System.out.print(i);
//		}
//	}
//}
