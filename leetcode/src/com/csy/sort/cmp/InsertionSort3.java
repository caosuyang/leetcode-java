package com.csy.sort.cmp;

/**
 * 插入排序（Insertion Sort）
 * @author csy
 *
 */
public class InsertionSort3 {
	/**
	 * 二分搜索优化
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
			// 先将待插入元素备份
			int ele = array[cur];
			// 待插入位置是insertIndex，也就是[insertIndex, begin) 范围年内元素都比待插入元素大
			int insertIndex = insertIndex(array, cur);
			// 头部有序数据中比待插入元素大的，都朝着尾部方向挪动1个位置
			// 也就是将 [insertIndex, begin) 范围内的元素往右边挪动一个单位
			for (int i = begin; i > insertIndex; i--) {
				array[i] = array[i - 1];
			}
			// 将待插入元素放到最终合适的位置
			array[insertIndex] = ele;
		}
		return array;
	}
	
	/**
	 * 查找v在有序数组array中待插入的位置，优化条件合并
	 * 要求二分搜索返回的插入位置：第一个大于v的元素位置
	 * @param array
	 * @param 
	 * @return
	 */
	public int insertIndex(int[] array, int index) {
		int begin = 0, end = index;
		while (begin < end) {
			int mid = (begin + end) >> 1;
			if (cmp(array, index, mid) < 0) {
				end = mid;
			} else {// v >= array[mid]
				// 插入位置是第一个大于v的元素位置
				begin = mid + 1;
			}
		}
		// v >= array[mid]时，插入位置正好为begin
		return begin;
	}
	
	
	/**
	 * 查找v在有序数组array中待插入的位置，优化条件合并
	 * 要求二分搜索返回的插入位置：第一个大于v的元素位置
	 * @param array
	 * @param 
	 * @return
	 */
	public int insertIndex1(int[] array, int v) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int begin = 0, end = array.length;
		while (begin < end) {
			int mid = (begin + end) >> 1;
			if (v < array[mid]) {
				end = mid;
			} else {// v >= array[mid]
				// 插入位置是第一个大于v的元素位置
				begin = mid + 1;
			}
		}
		// v >= array[mid]时，插入位置正好为begin
		return begin;
	}
	
	/**
	 * 比较数组中e1和e2两个元素值的大小
	 * 返回值等于0，代表 e1 == e2
	 * 返回值小于0，代表 e1 < e2
	 * 返回值大于0，代表 e1 > e2
	 * @param array
	 * @param i1
	 * @param i2
	 * @return
	 */
	public int cmp(int e1, int e2) {
		return e1 - e2;
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
		InsertionSort3 bs = new InsertionSort3();
		array = bs.insertionSort(array);
		for (int i : array) {
			System.out.print(i);
		}
	}
}
