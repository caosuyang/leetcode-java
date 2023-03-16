package com.csy.sort.cmp;

/**
 * 选择排序（Selection Sort）
 * @author csy
 *
 */
public class SelectionSort2 {
	/**
	 * 重复遍历，头尾指针，与末尾交换
	 * 优化1：使用堆来选择最大值【待优化】
	 * 时间复杂度：O(n^2)
	 * 空间复杂度：O(1)
	 * 稳定性：不稳定
	 * 属于原地算法
	 * @param array
	 * @return
	 */
	public int[] selectionSort(int[] array) {
		for (int end = array.length - 1; end > 0; end--) {
			// 从序列中找出最大元素
			int max = 0;
			for (int begin = 1; begin <= end; begin++) {
				// array[max] < array[begin]
				if (cmp(array, max, begin) < 0) {
					max = begin;
				}
			}
			// 与末尾元素交换位置
			swap(array, max, end);
		}// 忽略找到的最大元素，重复执行
		return array;
	}
	
	/**
	 * 比较数组中index1和index2位置元素值的大小
	 * 返回值等于0，代表 array[i1] == array[i2]
	 * 返回值小于0，代表 array[i1] < array[i2]
	 * 返回值大于0，代表 array[i1] > array[i2]
	 * @param array
	 * @param i1
	 * @param i2
	 * @return
	 */
	public int cmp(int[] array, int i1, int i2) {
		return array[i1] - array[i2];
	}
	
	/**
	 * 交换数组中index1和index2位置元素的位置
	 * @param array
	 * @param i1
	 * @param i2
	 */
	public void swap(int[] array, int i1, int i2) {
		int tmp = array[i1];
		array[i1] = array[i2];
		array[i2] = tmp;
	}
	
	/**
	 * test
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {7, 3, 5, 8, 6, 7, 4, 5};
		SelectionSort2 ss = new SelectionSort2();
		array = ss.selectionSort(array);
		for (int i : array) {
			System.out.print(i);
		}
	}
}
