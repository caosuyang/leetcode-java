package com.csy.sort.cmp;

/**
 * 快速排序（Quick Sort）
 * @author csy
 *
 */
public class QuickSort {
	/**
	 * 递归
	 * 时间复杂度：O(nlogn)
	 * 空间复杂度：O(logn)
	 * 稳定性：不稳定
	 * 属于原地算法
	 * @param array
	 * @return
	 */
	public int[] quickSort(int[] array) {
		if (array == null || array.length == 0) {
			return null;
		}
		sort(array, 0, array.length);
		return array;
	}
	
	/**
	 * 对 [begin, end) 范围的元素进行快速排序
	 * @param beigin
	 * @param end
	 */
	public void sort(int[] array, int beigin, int end) {
		// 至少2个元素才能继续分割操作
		if (end - beigin < 2) {
			return;
		}
		// 从序列中选择一个轴点元素，这里做法类似于归并排序的分割操作
		// 确定轴点位置 O(n)
		int mid = pivotIndex(array, beigin, end);
		// 对子序列进行快速排序
		sort(array, beigin, mid);
		sort(array, mid + 1, end);
	}
	
	/**
	 * 构造出 [begin, end) 范围的轴点元素
	 * 随机选择轴点元素，为了降低最坏情况出现概率
	 * @param beigin
	 * @param end
	 * @return 轴点元素的最终位置
	 */
	public int pivotIndex(int[] array, int begin, int end) {
		// 随机选择一个位置
		int random = begin + (int) (Math.random() * (end - begin));
		// 将随机选择的这个位置元素与begin位置元素交换
		swap(array, begin, random);
		// 把轴点元素先存下来
		int pivot = array[begin];
		// 下面逻辑，不是很明白？？？
		end--; // end指向最后一个元素
		while (begin < end) {
			// 利用 pivot 将序列分割成 2 个子序列
			while (begin < end) {
				// 将大于 pivot 的元素放在pivot后面（右侧）
				if (cmp(pivot, array[end]) < 0) { // 右边元素 > 轴点元素
					end--;
				} else { // 右边元素 <= 轴点元素
					array[begin] = array[end];
					begin++;
					break;
				}
			}
			while (begin < end) {
				// 将小于 pivot 的元素放在pivot前面（左侧）
				if (cmp(pivot, array[begin]) > 0) { // 左边元素 < 轴点元素
					begin++;
				} else { // 左边元素 >= 轴点元素
					array[end] = array[begin];
					end--;
					break;
				}
			}
		}
		// 将轴点元素放入最终的位置
		array[begin] = pivot;
		// 返回轴点元素的位置
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
		QuickSort bs = new QuickSort();
		array = bs.quickSort(array);
		for (int i : array) {
			System.out.print(i);
		}
	}
}
