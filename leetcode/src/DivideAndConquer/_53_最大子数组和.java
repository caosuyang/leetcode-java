package DivideAndConquer;

/**
 * 练习1 – 最大连续子序列和
 * https://leetcode.cn/problems/maximum-subarray/
 * @author csy
 *
 */
public class _53_最大子数组和 {

	/**
	 * 方法一 暴力
	 * 时间复杂度 n^3
	 * 空间复杂度 1
	 * 超出时间限制
	 * @param nums
	 * @return
	 */
    public int maxSubArray(int[] nums) {
    	if (nums == null || nums.length == 0) {
			return 0;
		} else if (nums.length == 1) {
			return nums[0];
		}
    	int max = Integer.MIN_VALUE;
    	for (int begin = 0; begin < nums.length; begin++) {
    		for (int end = begin; end < nums.length; end++) {
    			int sum = 0;
    			for (int i = begin; i <= end; i++) {
					sum += nums[i];
				}
    			max = Math.max(sum, max);
			}
		}
    	return max;
    }
    
	/**
	 * 方法二 暴力优化
	 * 重复利用前面计算过的结果
	 * 时间复杂度 n^2
	 * 空间复杂度 1
	 * 超出时间限制
	 * @param nums
	 * @return
	 */
    public int maxSubArray1(int[] nums) {
    	if (nums == null || nums.length == 0) {
			return 0;
		} else if (nums.length == 1) {
			return nums[0];
		}
    	int max = Integer.MIN_VALUE;
    	for (int begin = 0; begin < nums.length; begin++) {
    		int sum = 0;
    		for (int end = begin; end < nums.length; end++) {
    			sum += nums[end];
    			max = Math.max(sum, max);
			}
		}
    	return max;
    }
    
	/**
	 * 方法三 分治
	 * 时间复杂度 nlogn
	 * 空间复杂度 logn
	 * @param nums
	 * @return
	 */
    public int maxSubArray2(int[] nums) {
    	if (nums == null || nums.length == 0) {
			return 0;
		} else if (nums.length == 1) {
			return nums[0];
		}
    	return maxSubArray(nums, 0, nums.length);
    }
    
    /**
◼ 将序列均匀地分割成 2 个子序列
[begin , end) = [begin , mid) + [mid , end)，mid = (begin + end) >> 1
◼ 假设 [begin , end) 的最大连续子序列和是 S[i , j) ，那么它有 3 种可能
[i , j) 存在于 [begin , mid) 中，同时 S[i , j) 也是 [begin , mid) 的最大连续子序列和
[i , j) 存在于 [mid , end) 中，同时 S[i , j) 也是 [mid , end) 的最大连续子序列和
[i , j) 一部分存在于 [begin , mid) 中，另一部分存在于 [mid , end) 中 ✓ [i , j) = [i , mid) + [mid , j)
✓ S[i , mid) = max { S[k , mid) }，begin ≤ k ＜ mid
✓ S[mid , j) = max { S[mid , k) }，mid ＜ k ≤ end
[i , j) [i , j)
[begin , mid) [mid , end)
[i , mid) [mid , j)
     * @param nums
     * @param begin
     * @param end
     * @return
     */
    public int maxSubArray(int[] nums, int begin, int end) {
    	if (end - begin < 2) {
			return nums[begin];
		}
    	int mid = (begin + end) >> 1;
    	int leftMax = nums[mid - 1];
    	int leftSum = leftMax;
    	for (int i = mid - 2; i >= begin; i--) {
			leftSum += nums[i];
			leftMax = Math.max(leftSum, leftMax);
		}
    	
    	int rightMax = nums[mid];
    	int rightSum = rightMax;
    	for (int i = mid + 1; i < end; i++) {
			rightSum += nums[i];
			rightMax = Math.max(rightSum, rightMax);
		}
    	
    	int max = leftMax + rightMax;
    	int lMax = maxSubArray(nums, begin, mid);
    	int rMax = maxSubArray(nums, mid, end);
    	max = Math.max(max, Math.max(lMax, rMax));
		return max;
	}
    
    
    
	/**
	 * 方法四 大数乘法
	 * @param nums
	 * @return
	 */
    public int maxSubArray3(int[] nums) {
    	return 0;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
