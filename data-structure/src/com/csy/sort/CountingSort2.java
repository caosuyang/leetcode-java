package com.csy.sort;

/**
 * 计数排序（Counting Sort）
 * @author csy
 *
 */
public class CountingSort2 {
	/**
	 * 统计每个整数在序列中出现的次数
	 * 时间复杂度：O(n+k)，k 是整数的取值范围
	 * 空间复杂度：O(n+k)，k 是整数的取值范围
	 * 稳定性：稳定
	 * 不属于原地算法
	 * @param array
	 * @return
	 */
	public int[] countingSort(int[] array) {
		// 找出最值
		int max = array[0];
		int min = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
			if (array[i] < min) {
				min = array[i];
			}
		}
		// 开辟内存空间，存储次数
		// max-min+1就是存放素有整数出现次数数组的len
		int[] counts = new int[max - min + 1];
		// 统计每个整数出现的次数
		for (int i = 0; i < array.length; i++) {
			// 从索引0开始依次存放3~8出现的次数
			int index = array[i] - min;
			counts[index]++;
		}
		// 累加次数
		for (int i = 1; i < counts.length; i++) {
			// 每个次数累加上其前面的所有次数，得到的就是元素在有序序列中的位置信息
			counts[i] += counts[i - 1];
		}
		
		// 用于存放排好序的数据
		int[] newArray = new int[array.length];
		// 从后往前遍历元素，将它放到有序数组中的合适位置
		for (int i = array.length - 1; i >= 0; i--) {
			// 这段逻辑看不懂？？？？
			int index = array[i] - min;
			counts[index]--;
			newArray[counts[index]] = array[i];
		}
		
		// 将有序数组赋值到array
		for (int i = 0; i < array.length; i++) {
			array[i] = newArray[i];
		}
		return array;
	}
	
	/**
	 * test
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {7, 3, 5, 8, 6, 7, 4, 5};
		CountingSort2 bs = new CountingSort2();
		array = bs.countingSort(array);
		for (int i : array) {
			System.out.print(i);
		}
	}
}
