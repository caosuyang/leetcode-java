package Tags.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://leetcode.cn/problems/intersection-of-two-arrays/
 * @author csy
 *
 */
public class _349_两个数组的交集 {
	/**
	 * 一个集合，遍历 
	 * 时间复杂度：O(mn)
	 * 空间复杂度：O(m + n)
	 * @param nums1
	 * @param nums2
	 * @return 解答错误？？？
	 */
    public int[] intersection(int[] nums1, int[] nums2) {
    	Set<Integer> set = new TreeSet<>();
    	// 遍历数组 nums1，对于其中的每个元素，遍历数组 nums2
    	for (Integer num1 : nums1) {
        	for (Integer num2 : nums2) {
        		// 判断该元素是否在数组 nums2 中，如果存在，则将该元素添加到返回值
        		// 这里是num1.compareTo(num2) == 0，而不是num1 == num2
        		if (num1.compareTo(num2) == 0) {
        			set.add(num1);
    			}
    		}
		}
    	int[] list = new int[set.size()];
    	int index = 0;
    	for (int num : set) {
    		list[index++] = num;
		}
		return Arrays.copyOfRange(list, 0, index);
    }
    
	/**
	 * 两个集合，遍历
	 * 时间复杂度：O(m + n)
	 * 空间复杂度：O(m + n)
	 * @param nums1
	 * @param nums2
	 * @return
	 */
    public int[] intersection2(int[] nums1, int[] nums2) {
    	Set<Integer> set1 = new HashSet<>();
    	Set<Integer> set2 = new HashSet<>();
    	for (int num : nums1) {
			set1.add(num);
		}
    	for (int num : nums2) {
			set2.add(num);
		}
    	return getIntersection(set1, set2);
    }
    
    public int[] getIntersection(Set<Integer> set1, Set<Integer> set2) {
		if (set1.size() > set2.size()) {
			return getIntersection(set2, set1);
		}
    	Set<Integer> set = new HashSet<>();
    	for (int num : set1) {
			if (set2.contains(num)) {
				set.add(num);
			}
		}
    	int[] list = new int[set.size()];
    	int index = 0;
    	for (int num : set) {
			list[index] = num;
			index++;
		}
    	return list;
	}
    
	/**
	 * 排序+双指针
	 * 时间复杂度：O(mlogm + nlogn)
	 * 空间复杂度：O(logm + logn)
	 * @param nums1
	 * @param nums2
	 * @return
	 */
    public int[] intersection3(int[] nums1, int[] nums2) {
    	// 首先对两个数组排序
    	Arrays.sort(nums1);
    	Arrays.sort(nums2);
    	int len1 = nums1.length;
    	int len2 = nums2.length;
    	int[] list = new int[len1 + len2];
    	// 初始化一个指针指向list数组头部
    	// 初始时两个指针分别指向两个数组的头部
    	int index = 0, index1 = 0, index2 = 0;
    	// 当其中一个指针超出数组长度，遍历结束
    	while (index1 < len1 && index2 < len2) {
    		int num1 = nums1[index1], num2 = nums2[index2];
    		if (num1 != num2) {
    			// 如果两个数字不相等，则将指向较小数字的指针右移一位
				if (num1 < num2) {
					index1++;
				} else {
					index2++;
				}
			} else {
				// 使用额外记录变量 list[index - 1] 表示上一次加入答案数组的元素
				// 如果两个数字相等，且该数字不等于 list[index - 1]
				if (index == 0 || num1 != list[index - 1]) {
					// 将该数字添加到答案并更新 prev 变量
					list[index++] = num1;
				}
				// 同时将两个指针都右移一位
				// 不管if (index == 0 || num1 != list[index - 1])的条件，都要++
				index1++;
				index2++;
			}
		}
    	return Arrays.copyOfRange(list, 0, index);
    }
}
