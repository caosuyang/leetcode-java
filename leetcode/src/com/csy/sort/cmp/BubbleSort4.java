package com.csy.sort.cmp;

/**
 * 冒泡排序（Bubble Sort）
 * @author csy
 *
 */
public class BubbleSort4 {
	/**
	 * 重复遍历，头尾指针
	 * 优化2：如果序列尾部已经局部有序，可以记录最后一次交换的位置，减少比较次数
	 * 时间复杂度：O(n^2)
	 * 空间复杂度：O(1)
	 * 稳定性：稳定
	 * 属于原地算法
	 * @param array
	 * @return
	 */
	public int[] bubbleSort(int[] array) {
		// 从尾部开始遍历
		for (int end = array.length - 1; end > 0; end--) {
			int sortedIndex = 1;
			// 注意：begin <= end，而不是begin < end
			for (int begin = 1; begin <= end; begin++) {
				// 比较每一对相邻元素，如果array[begin] < array[begin - 1]
				if (cmp(array, begin, begin - 1) < 0) {
					// 就交换这两个相邻元素的位置
					swap(array, begin, begin - 1);
					sortedIndex = begin;
				}
			}// 这里for2循环执行完一轮后，最末尾元素是最大元素
			// 如果序列尾部已经局部有序，可以记录最后一次交换的位置，减少比较次数
			end = sortedIndex;
		}// 继续for1循环执行遍历，直到全部元素依次从小到大排序
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
		BubbleSort4 bs = new BubbleSort4();
		array = bs.bubbleSort(array);
		for (int i : array) {
			System.out.print(i);
		}
	}
}
