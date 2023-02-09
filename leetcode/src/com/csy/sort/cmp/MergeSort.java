package com.csy.sort.cmp;

/**
 * 归并排序（Merge Sort）
 * @author csy
 *
 */
public class MergeSort {
	/**
	 * divide实现，分割通过递归，合并通过指针
	 * 时间复杂度：O(nlogn)
	 * 空间复杂度：O(n)
	 * 稳定性：稳定
	 * 不属于原地算法
	 * @param array
	 * @return
	 */
	public int[] mergeSort(int[] array) {
		// 准备一段临时的数组空间，在merge操作中使用
		int[] leftArray = new int[array.length >> 1];
		sort(array, leftArray, 0, array.length);
		return array;
	}
	
	/**
	 * 不断的将当前序列平均分割成2个子序列
	 * 分割数据范围[begin, end)
	 * @param array
	 * @param leftArray
	 * @param begin
	 * @param end
	 */
	public void sort(int[] array, int[] leftArray, int begin, int end) {
		// 直到不能再分割（序列中只剩一个元素，return）
		if (end - begin < 2) {
			return;
		}
		int mid = (begin + end) >> 1;
		sort(array, leftArray, begin, mid);
		sort(array, leftArray, mid, end);
		merge(array, leftArray, begin, mid, end);
	}
	
	/**
	 * 不断的将2个子序列合并成一个有序序列
	 * 2个子序列范围分别是[begin,mid)、[mid,end)
	 * @param array
	 * @param leftArray
	 * @param begin
	 * @param mid
	 * @param end
	 */
	public void merge(int[] array, int[] leftArray, int begin, int mid, int end) {
		// 需要merge的2组序列存在于通过一个数组中，并且挨在一起
		int li = 0, le = mid - begin; // 左边数组（基于leftArray）
		int ri = mid, re = end; // 右边数组（基于array）
		int ai = begin; // array的索引
		for (int i = li; i < le; i++) { // 拷贝左边数组到leftArray
			leftArray[i] = array[begin + i];
		}
		// 此处操作逻辑类似于_88_合并两个有序数组
		while (li < le) {
			if (ri < re && cmp(array[ri], leftArray[li]) < 0) { // array[ri]<leftArray[li] 
				array[ai++] = array[ri++]; // 拷贝右边数组到array
			} else {
				array[ai++] = leftArray[li++]; // 拷贝左边数组到array
			}
		}// 注意：cmp位置改为<=会失去稳定性
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
		MergeSort bs = new MergeSort();
		array = bs.mergeSort(array);
		for (int i : array) {
			System.out.print(i);
		}
	}
}
