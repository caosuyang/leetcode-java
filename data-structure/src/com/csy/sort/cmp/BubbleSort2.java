package com.csy.sort.cmp;

/**
 * 冒泡排序（Bubble Sort）
 * 方法二：两层遍历+如果序列完全有序，提前终止
 * 912. 排序数组
 * https://leetcode.cn/problems/sort-an-array/
 * @author csy
 *
 */
public class BubbleSort2 {
	/**
	 * 两层遍历+如果序列完全有序，提前终止
	 * 最坏、平均时间复杂度，总是需要两层遍历 O(n^2)
	 * 最优时间复杂度，一次遍历发现完全有序 O(n)
	 * 空间复杂度 O(1)，没有额外堆空间和递归调用
	 * 属于稳定的排序算法，nums[begin - 1] > nums[begin]
	 * 属于原地算法，没有依赖外部资源，只对传入参数nums进行修改和覆盖
	 * leetcode执行结果：10 / 20 个通过的测试用例，超出时间限制
	 * @param nums
	 * @return
	 */
    public int[] sortArray(int[] nums) {
    	for (int end = nums.length - 1; end > 0; end--) {
    		boolean sorted = true;
        	for (int begin = 1; begin <= end; begin++) {
    			// left: nums[begin - 1]
    			// right: nums[begin]
    			if (nums[begin - 1] > nums[begin]) {
    				int tmp = nums[begin - 1];
    				nums[begin - 1] = nums[begin];
    				nums[begin] = tmp;
    				sorted = false;
    			}
    		}
        	if (sorted) break;
		}
    	return nums;
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
     */
    public static void main(String[] args) {
//		int[] array = {7, 3, 5, 8, 6, 7, 4, 5};
//    	int[] array = {5,2,3,1};
    	int[] array = {5,1,1,2,0,0};
		BubbleSort2 bs = new BubbleSort2();
		array = bs.sortArray(array);
		for (int i : array) {
			System.out.print(i);
		}
	}
}


///**
// * 冒泡排序（Bubble Sort）
// * @author csy
// *
// */
//public class BubbleSort2 {
//	/**
//	 * 重复遍历，头尾指针
//	 * 优化1：如果序列已经完全有序，提前终止冒泡排序
//	 * 时间复杂度：O(n^2)
//	 * 空间复杂度：O(1)
//	 * 稳定性：稳定
//	 * 属于原地算法
//	 * @param array
//	 * @return
//	 */
//	public int[] bubbleSort(int[] array) {
//		// 从尾部开始遍历
//		for (int end = array.length - 1; end > 0; end--) {
//			boolean sorted = true;
//			// 注意：begin <= end，而不是begin < end
//			for (int begin = 1; begin <= end; begin++) {
//				// 比较每一对相邻元素，如果array[begin] < array[begin - 1]
//				if (cmp(array, begin, begin - 1) < 0) {
//					// 就交换这两个相邻元素的位置
//					swap(array, begin, begin - 1);
//					sorted = false;
//				}
//			}// 这里for2循环执行完一轮后，最末尾元素是最大元素
//			// 如果序列已经完全有序，提前终止冒泡排序
//			if (sorted) {
//				break;
//			}
//		}// 继续for1循环执行遍历，直到全部元素依次从小到大排序
//		return array;
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
//		BubbleSort2 bs = new BubbleSort2();
//		array = bs.bubbleSort(array);
//		for (int i : array) {
//			System.out.print(i);
//		}
//	}
//}
