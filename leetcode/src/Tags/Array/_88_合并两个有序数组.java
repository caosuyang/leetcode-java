package Tags.Array;
/**
 * https://leetcode.com/problems/merge-sorted-array/
 * @author csy
 *
 */
public class _88_合并两个有序数组 {

	/**
	 * 三指针
	 * 时间复杂度：O（n）
	 * 空间复杂度：O（1）
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	int i1 = m - 1;
    	int i2 = n - 1;
    	int cur = m + n - 1;
    	while (i2 >= 0) {
			if (i1 >= 0 && nums1[i1] > nums2[i2]) {
				nums1[cur--] = nums1[i1--];
			} else {// i1 < 0 || nums1[i1] <= nums2[i2]
				nums1[cur--] = nums2[i2--];
			}
		}
    }
    
    /**
     * test
     * @param args
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		_88_合并两个有序数组 o = new _88_合并两个有序数组();
		int[] nums1 = {1,2,3,0,0,0};
		int m = 3;
		int[] nums2 = {2,5,6};
		int n = 3;
		int[] out = {1,2,2,3,5,6};
		o.merge(nums1, m, nums2, n);
		System.out.println(nums1.toString());
		
//		_88_合并两个有序数组 o = new _88_合并两个有序数组();
//		int[] nums1 = {1};
//		int m = 1;
//		int[] nums2 = {};
//		int n = 0;
//		int[] out = {1};
//		o.merge(nums1, m, nums2, n);
//		System.out.println(nums1.toString());
//		
//		_88_合并两个有序数组 o = new _88_合并两个有序数组();
//		int[] nums1 = {0};
//		int m = 0;
//		int[] nums2 = {1};
//		int n = 1;
//		int[] out = {1};
//		o.merge(nums1, m, nums2, n);
//		System.out.println(nums1.toString());
	}

}
