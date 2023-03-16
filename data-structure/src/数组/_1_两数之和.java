package 数组;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum/
 * @author myfolders
 *
 */
public class _1_两数之和 {
	// 方法一：暴力法
	public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] == target - nums[i]) {
					return new int[] {i, j};
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
    }
	
	// 方法二：两遍哈希表
	public int[] twoSum2(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			
			if (map.containsKey(complement) && map.get(complement) != i) {
				return new int[] {i, map.get(complement)};
			}
		}
		
		throw new IllegalArgumentException("No two sum solution");
    }
	
	// 方法三：一遍哈希表
	public int[] twoSum3(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			
			if (map.containsKey(complement)) {
				return new int[] {map.get(complement), i};
			}
			map.put(nums[i], i);
		}
		
		throw new IllegalArgumentException("No two sum solution");
	}
}
