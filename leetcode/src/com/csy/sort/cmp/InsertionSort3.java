package com.csy.sort.cmp;

/**
 * 插入排序（Insertion Sort）
 * @author csy
 *
 */
public class InsertionSort3 {
	/**
	 * 两次扫描，挪动
	 * 优化1：将交换转为挪动
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
			// 头部有序数据中比待插入元素大的，都朝着尾部方向挪动1个位置
			while (cur > 0 && cmp(ele, array[cur - 1]) < 0) {
				array[cur] = array[cur - 1];
				cur--;
			}
			// 将待插入元素放到最终合适的位置
			array[cur] = ele;
		}
		return array;
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
