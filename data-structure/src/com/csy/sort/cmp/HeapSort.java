package com.csy.sort.cmp;

/**
 * 堆排序（Heap Sort）
 * @author csy
 *
 */
public class HeapSort {
	/**
	 * 使用堆来选择最大值，与末尾交换
	 * 可以认为是对选择排序的一种优化
	 * 时间复杂度：O(nlogn)
	 * 空间复杂度：O(1)
	 * 稳定性：不稳定
	 * 属于原地算法
	 * @param array
	 * @return
	 */
	public int[] heapSort(int[] array) {
		// 对序列进行原地建堆(heapify)
		int heapSize = array.length;
		heapify(array, heapSize);
		
		// 重复执行，直到堆元素数量为1
		while (heapSize > 1) {
			// 堆的元素数量减1
			// 注意：必须先--，否则swap内部数组越界
			heapSize--;
			// 交换堆顶元素和尾元素
			swap(array, 0, heapSize);
			// 对0位置进行一次shifDown操作（恢复堆的性质）
			shifDown(array, heapSize, 0);
		}
		return array;
	}

	/**
	 * 原地建堆
	 * 参照堆的实现
	 * @param heapSize
	 */
	public void heapify(int[] array, int heapSize) {
		for (int i = (heapSize >> 1) - 1; i >= 0; i--) {
			shifDown(array, heapSize, i);
		}
	}

	/**
	 * 下滤
	 * 参照堆的实现
	 * @param index
	 */
	public void shifDown(int[] array, int heapSize, int index) {
		int ele = array[index];
		int half = heapSize >> 1;
		while (index < half) {// index必须是非叶子节点
			// 默认是左边跟父节点比
			int childIndex = (index << 1) + 1;
			int child = array[childIndex];
			int rightIndex = childIndex + 1;
			// 右子节点比左子节点大
			if (rightIndex < heapSize &&
					cmp(array[rightIndex], child) > 0) {
				child = array[childIndex = rightIndex];
			}
			// 大于等于子节点
			if (cmp(ele, child) >= 0) {
				break;
			}
			array[index] = child;
			index = childIndex;
		}
		array[index] = ele;
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
		HeapSort hs = new HeapSort();
		array = hs.heapSort(array);
		for (int i : array) {
			System.out.print(i);
		}
	}
}
