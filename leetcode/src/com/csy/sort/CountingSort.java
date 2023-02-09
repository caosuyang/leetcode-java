package com.csy.sort;

/**
 * 计数排序（Counting Sort）
 * @author csy
 *
 */
public class CountingSort {
	/**
	 * 统计每个整数在序列中出现的次数
	 * 时间复杂度：O(n+k)
	 * 空间复杂度：O(n+k)
	 * 稳定性：不稳定
	 * 不属于原地算法
	 * @param array
	 * @return
	 */
	public int[] countingSort(int[] array) {
		// 首先获取序列中的最大值
		int max = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		// 统计元素出现次数
		// max + 1就是存放素有整数出现次数数组的len
		int[] counts = new int[max + 1];
		for (int i = 0; i < array.length; i++) {
			int index = array[i];
			counts[index]++;
		}
		
		// 按顺序赋值
		// 初始化一个index指针指向array
		int index = 0;
		for (int i = 0; i < counts.length; i++) {
			while (counts[i]-- > 0) {
				array[index++] = i;
			}
		}
		return array;
	}
	
	/**
	 * test
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {7, 3, 5, 8, 6, 7, 4, 5};
		CountingSort bs = new CountingSort();
		array = bs.countingSort(array);
		for (int i : array) {
			System.out.print(i);
		}
	}
}
