package com.csy.sort;

/**
 * 基数排序（Radix Sort）
 * @author csy
 *
 */
public class RadixSort {
	/**
	 * 统计每个整数在序列中出现的次数
	 * 时间复杂度：O(d*(n+k))，d是最大值位数，k是进制
	 * 空间复杂度：O(n+k)，k是进制
	 * 稳定性：稳定
	 * 不属于原地算法
	 * @param array
	 * @return
	 */
	public int[] countingSort(int[] array) {
		// 最大值
		int max = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}

		// 个位数: array[i] / 1 % 10 = 3
		// 十位数：array[i] / 10 % 10 = 9
		// 百位数：array[i] / 100 % 10 = 5
		// 千位数：array[i] / 1000 % 10 = ...
		for (int divider = 1; divider <= max; divider *= 10) {
			// 对每一位进行计数排序
			countingSort(array, divider);
		}
		return array;
	}
	
	/**
	 * 对每一位进行计数排序
	 * @param array
	 * @param divider
	 */
	public void countingSort(int[] array, int divider) {
		// 这里逻辑和计数排序优化操作一致
		// 开辟内存空间，存储次数
		int counts[] = new int[10]; // 0 - 9
		for (int i = 0; i < counts.length; i++) {
			counts[i] = 0;
		}
		// 统计每个整数出现的次数
		for (int i = 0; i < array.length; i++) {
			counts[array[i] / divider % 10]++;
		}
		// 累加次数
		// 注意这里i = 1，而不是 i = 0
		for (int i = 1; i < counts.length; i++) {
			counts[i] += counts[i - 1];
		}
		// 从后往前遍历元素，将它放到有序数组中的合适位置
		int newArray[] = new int[array.length];
		for (int i = array.length - 1; i >= 0; i--) {
			newArray[--counts[array[i] / divider % 10]] = array[i];
		}
		// 将有序数组赋值到array
		for (int i = 0; i < array.length; i++) {
			array[i] = newArray[i];
		}
	}

	/**
	 * test
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {7, 3, 5, 8, 6, 7, 4, 5};
		RadixSort bs = new RadixSort();
		array = bs.countingSort(array);
		for (int i : array) {
			System.out.print(i);
		}
	}
}
