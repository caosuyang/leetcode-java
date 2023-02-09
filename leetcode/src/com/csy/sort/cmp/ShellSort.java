package com.csy.sort.cmp;

import java.util.ArrayList;
import java.util.List;

/**
 * 希尔排序（Shell Sort）
 * @author csy
 *
 */
public class ShellSort {
	/**
	 * 底层使用插入排序对每一列进行排序
	 * 所以希尔排序可以说是插入排序的改进
	 * 时间复杂度：O(n^2)
	 * 空间复杂度：O(1)
	 * 稳定性：不稳定
	 * 属于原地算法
	 * @param array
	 * @return
	 */
	public int[] shellSort(int[] array) {
		List<Integer> stepSequence = shellStepSequence(array);
		for (Integer step : stepSequence) {
			sort(array, step);
		}
		return array;
	}
	
	/**
	 * 分成step列进行排序
	 * @param array
	 * @param step
	 */
	public void sort(int[] array, int step) {
		// 假设元素在第col列，第row行，步长（总列数）是step
		// col : 第几列，column的简称
		for (int col = 0; col < step; col++) { // 对第col列进行排序
			// col、col+step、col+2*step、col+3*step，这里一直取的是每一个列的第一个元素
			// 往下这里逻辑，看不明白？？？？
			for (int begin = col + step; begin < array.length; begin += step) {
				int cur = begin;
				while (cur > col && cmp(array, cur, cur - step) < 0) {
					swap(array, cur, cur - step);
					cur -= step;
				}
			}
		}
	}
	
	/**
	 * 希尔给出的步长序列，最坏时间复杂度：O(n^2)
	 * @param array
	 * @return
	 */
	public List<Integer> shellStepSequence(int[] array) {
		List<Integer> stepSequence = new ArrayList<>();
		int step = array.length;
		// 注意：这里step >>= 1，而不是step >> 1
		while ((step >>= 1) > 0) {
			stepSequence.add(step);
		}
		return stepSequence;
	}
	
	/**
	 * 已知最好情况的步长序列，最坏时间复杂度：O(n^4/3)
	 * @param array
	 * @return
	 */
	public List<Integer> sedgewickStepSequence(int[] array) {
		List<Integer> stepSequence = new ArrayList<>();
		// 下面的逻辑看不懂？？？？
		int k = 0, step = 0;
		while (true) {
			if (k % 2 == 0) {
				int pow = (int) Math.pow(2, k >> 1);
				step = 1 + 9 * (pow * pow - pow);
			} else {
				int pow1 = (int) Math.pow(2, (k + 1) >> 1);
				int pow2 = (int) Math.pow(2, (k + 1) >> 1);
				step = 1 + 8 * pow1 * pow2 - 6 * pow2;
			}
			if (step >= array.length) {
				break;
			}
			stepSequence.add(0, step);
			k++;
		}
		return stepSequence;
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
		ShellSort bs = new ShellSort();
		array = bs.shellSort(array);
		for (int i : array) {
			System.out.print(i);
		}
	}
}
