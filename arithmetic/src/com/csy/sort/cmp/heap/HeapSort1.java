package com.csy.sort.cmp.heap;

/**
 * 堆排序（Heap Sort）
 * 方法一：两层遍历+使用堆来选择最大值
 * 912. 排序数组
 * https://leetcode.cn/problems/sort-an-array/
 * @author csy
 *
 */
public class HeapSort1 {
	/**
	 * 两层遍历+使用堆来选择最大值
	 * 最坏、平均、最优时间复杂度，扫描一遍元素*每次对0位置下滤操作 O(nlogn)
	 * 空间复杂度 O(1)，没有额外堆空间和递归调用
	 * 属于不稳定的排序算法，将堆顶元素与最后一个元素交换，会把相同最大两个元素位置顺序打乱
	 * 属于原地算法，没有依赖外部资源，只对传入参数nums进行修改和覆盖
	 * @param nums
	 * @return
	 */
    public int[] sortArray(int[] nums) {
    	int size = nums.length;
    	// 原地建堆
    	heapify(size, nums);
    	
    	// 如果堆内只剩一个元素，结束交换
    	while (size > 1) {
        	// 将堆顶元素与最后一个元素交换
			int tmp = nums[size - 1];
			nums[size - 1] = nums[0];
			nums[0] = tmp;
			
        	// 堆size减1
        	size--;
        	
        	// 对0位置进行一次下滤操作
        	shiftDown(0, nums, size);
		}
    	return nums;
    }
    
    /**
     * 对序列进行原地建堆
     * @param size
     */
    private void heapify(int size, int[] nums) {
		// 自下而上的下滤
		for (int i = (size >> 1) - 1; i >= 0; i--) {
			shiftDown(i, nums, size);
		}
	}
    
    /**
     * 让index位置的元素下滤
     * @param index
     */
    private void shiftDown(int index, int[] nums, int size) {
		int element = nums[index];
		int half = size >> 1;
		// 第一个叶子节点的索引 == 非叶子节点的数量
		// index < 第一个叶子节点的索引
		// 必须保证index位置是非叶子节点
		while (index < half) { 
			// index的节点有2种情况
			// 1.只有左子节点
			// 2.同时有左右子节点
			
			// 默认为左子节点跟它进行比较
			int childIndex = (index << 1) + 1;
			int child = nums[childIndex];
			
			// 右子节点
			int rightIndex = childIndex + 1;
			
			// 选出左右子节点最大的那个
			if (rightIndex < size && nums[rightIndex] > child) {
				child = nums[childIndex = rightIndex];
			}
			
			if (element >= child) break;

			// 将子节点存放到index位置
			nums[index] = child;
			// 重新设置index
			index = childIndex;
		}
		nums[index] = element;
	}
    
    /**
     * 912. 排序数组
     * 给你一个整数数组 nums，请你将该数组升序排列。
     * 示例 1：
     * 输入：nums = [5,2,3,1]
     * 输出：[1,2,3,5]
     * 示例 2：
     * 输入：nums = [5,1,1,2,0,0]
     * 输出：[0,0,1,1,2,5]
     * 提示：
     * 1 <= nums.length <= 5 * 104
     * -5 * 104 <= nums[i] <= 5 * 104
     * @param args
     * leetcode执行结果：12 / 20 个通过的测试用例，超出时间限制
     */
    public static void main(String[] args) {
//		int[] array = {7, 3, 5, 8, 6, 7, 4, 5};
//    	int[] array = {5,2,3,1};
    	int[] array = {5,1,1,2,0,0};
    	HeapSort1 hs = new HeapSort1();
		array = hs.sortArray(array);
		for (int i : array) {
			System.out.print(i);
		}
	}
}

///**
// * 堆排序（Heap Sort）
// * @author csy
// *
// */
//public class HeapSort1 {
//	/**
//	 * 使用堆来选择最大值，与末尾交换
//	 * 可以认为是对选择排序的一种优化
//	 * 时间复杂度：O(nlogn)
//	 * 空间复杂度：O(1)
//	 * 稳定性：不稳定
//	 * 属于原地算法
//	 * @param array
//	 * @return
//	 */
//	public int[] heapSort(int[] array) {
//		// 对序列进行原地建堆(heapify)
//		int heapSize = array.length;
//		heapify(array, heapSize);
//		
//		// 重复执行，直到堆元素数量为1
//		while (heapSize > 1) {
//			// 堆的元素数量减1
//			// 注意：必须先--，否则swap内部数组越界
//			heapSize--;
//			// 交换堆顶元素和尾元素
//			swap(array, 0, heapSize);
//			// 对0位置进行一次shifDown操作（恢复堆的性质）
//			shifDown(array, heapSize, 0);
//		}
//		return array;
//	}
//
//	/**
//	 * 原地建堆
//	 * 参照堆的实现
//	 * @param heapSize
//	 */
//	public void heapify(int[] array, int heapSize) {
//		for (int i = (heapSize >> 1) - 1; i >= 0; i--) {
//			shifDown(array, heapSize, i);
//		}
//	}
//
//	/**
//	 * 下滤
//	 * 参照堆的实现
//	 * @param index
//	 */
//	public void shifDown(int[] array, int heapSize, int index) {
//		int ele = array[index];
//		int half = heapSize >> 1;
//		while (index < half) {// index必须是非叶子节点
//			// 默认是左边跟父节点比
//			int childIndex = (index << 1) + 1;
//			int child = array[childIndex];
//			int rightIndex = childIndex + 1;
//			// 右子节点比左子节点大
//			if (rightIndex < heapSize &&
//					cmp(array[rightIndex], child) > 0) {
//				child = array[childIndex = rightIndex];
//			}
//			// 大于等于子节点
//			if (cmp(ele, child) >= 0) {
//				break;
//			}
//			array[index] = child;
//			index = childIndex;
//		}
//		array[index] = ele;
//	}
//	
//	/**
//	 * 比较数组中e1和e2两个元素值的大小
//	 * 返回值等于0，代表 e1 == e2
//	 * 返回值小于0，代表 e1 < e2
//	 * 返回值大于0，代表 e1 > e2
//	 * @param array
//	 * @param i1
//	 * @param i2
//	 * @return
//	 */
//	public int cmp(int e1, int e2) {
//		return e1 - e2;
//	}
//	
//	/**
//	 * 比较数组中index1和index2位置元素值的大小
//	 * 返回值等于0，代表 array[i1] == array[i2]
//	 * 返回值小于0，代表 array[i1] < array[i2]
//	 * 返回值大于0，代表 array[i1] > array[i2]
//	 * @param array
//	 * @param i1
//	 * @param i2
//	 * @return
//	 */
//	public int cmp(int[] array, int i1, int i2) {
//		return array[i1] - array[i2];
//	}
//	
//	/**
//	 * 交换数组中index1和index2位置元素的位置
//	 * @param array
//	 * @param i1
//	 * @param i2
//	 */
//	public void swap(int[] array, int i1, int i2) {
//		int tmp = array[i1];
//		array[i1] = array[i2];
//		array[i2] = tmp;
//	}
//	
//	/**
//	 * test
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		int[] array = {7, 3, 5, 8, 6, 7, 4, 5};
//		HeapSort1 hs = new HeapSort1();
//		array = hs.heapSort(array);
//		for (int i : array) {
//			System.out.print(i);
//		}
//	}
//}
