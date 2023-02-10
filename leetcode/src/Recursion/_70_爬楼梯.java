package Recursion;

/**
 * https://leetcode.cn/problems/climbing-stairs/
 * @author csy
 *
 */
public class _70_爬楼梯 {
	/**
	 * 递归
	 * 时间复杂度 n^2
	 * 空间复杂度 n
	 * @param n
	 * @return
	 */
    public int climbStairs(int n) {
    	if (n < 3) {
			return n;
		}
    	return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * test
     * @param args
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_70_爬楼梯 cs = new _70_爬楼梯();
		int cs1 = cs.climbStairs(2);
		int cs2 = cs.climbStairs(3);
		System.out.println(cs1 + "_" + cs2);
	}

}
