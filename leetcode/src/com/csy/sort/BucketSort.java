package com.csy.sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 桶排序（Bucket Sort）
 * @author csy
 *
 */
public class BucketSort {
	/**
	 * 空间换时间，桶数组，二维数组
	 * 时间复杂度：O(m+n)，m是桶的数量
	 * 空间复杂度：O(n+k)
	 * 稳定性：稳定
	 * 不属于原地算法
	 * @param array
	 * @return
	 */
	public double[] bucketSort(double[] array) {
		// 桶数组
		@SuppressWarnings("unchecked")
		List<Double>[] buckets = new List[array.length];
		// 统计每个整数出现的次数，然后放到桶对应合适的位置
		for (int i = 0; i < array.length; i++) {
			int bucketIndex = (int) (array[i] * array.length);
			List<Double> bucket = buckets[bucketIndex];
			
			if (bucket == null) {
				bucket = new LinkedList<>();
				buckets[bucketIndex] = bucket;
			}
			bucket.add(array[i]);
		}
		// 对每个桶进行排序
		int index = 0;
		// 将有序数组赋值到array，因为是桶，二维数组，需要for两次
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] == null) {
				continue;
			}
			// 利用List类内部sort函数
			buckets[i].sort(null);
			for (Double d : buckets[i]) {
				array[index++] = d;
			}
		}
		return array;
	}

	/**
	 * test
	 * @param args
	 */
	public static void main(String[] args) {
		double[] array = {0.34, 0.47, 0.29, 0.84, 0.45, 0.38, 0.35, 0.76};
		BucketSort bs = new BucketSort();
		array = bs.bucketSort(array);
		for (double i : array) {
			System.out.print(i + "_");
		}
	}
}
