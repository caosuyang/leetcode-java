package com.csy.sort.cmp;

/**
 * 插入排序（Insertion Sort）
 * @author csy
 *
 */
public class InsertionSort {
	/**
	 * 两次扫描，交换
	 * 时间复杂度：O(n^2)
	 * 空间复杂度：O(1)
	 * 稳定性：稳定
	 * 属于原地算法
	 * @param array
	 * @return
	 */
	public int[] insertionSort(int[] array) {
		for (int begin = 1; begin < array.length; begin++) {
			// 初始cur指针指向尾部待排序的第一个位置
			int cur = begin;
			// 从头部已排序的序列，从尾部往前扫描每一个元素，
			while (cur > 0 && cmp(array, cur, cur - 1) < 0) {
				// 每扫描到一个元素，与cur指向的元素比较，如果cur比扫描到的大，那么交换位置，直到头部依旧保持有序
				swap(array, cur, cur - 1);
				cur--;
			}
		}
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
		InsertionSort bs = new InsertionSort();
		array = bs.insertionSort(array);
		for (int i : array) {
			System.out.print(i);
		}
	}
}
