package com.csy.sort;

/**
 * 基数排序（Radix Sort）
 * @author csy
 *
 */
public class RadixSort2 {
	/**
	 * 空间换时间，桶数组，二维数组
	 * 时间复杂度：O(dn)，d是最大值位数，k是进制
	 * 空间复杂度：O(kn+k)，d是最大值位数，k是进制
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

		// 开辟内存空间，存储次数
		// 桶数组
		int[][] buckets = new int[10][array.length]; // 0 - 9
		// 每个桶的元素数量
		int[] bucketSizes = new int[buckets.length];
		
		for (int divider = 1; divider <= max; divider *= 10) {
			// 统计每个整数出现的次数，然后放到桶对应合适的位置
			for (int i = 0; i < array.length; i++) {
				int no = array[i] / divider % 10;
				buckets[no][bucketSizes[no]++] = array[i];
			}
			int index = 0;
			// 将有序数组赋值到array，因为是桶，二维数组，需要for两次
			for (int i = 0; i < buckets.length; i++) {
				for (int j = 0; j < bucketSizes[i]; j++) {
					array[index++] = buckets[i][j];
				}
				// 每个桶元素数量置为0，不太明白这里？？？
				bucketSizes[i] = 0;
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
		RadixSort2 bs = new RadixSort2();
		array = bs.countingSort(array);
		for (int i : array) {
			System.out.print(i);
		}
	}
}
