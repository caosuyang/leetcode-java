package Recursion;

import java.awt.SecondaryLoop;

/**
 * https://leetcode.cn/problems/climbing-stairs/
 * @author csy
 *
 */
public class _70_爬楼梯2 {
	/**
	 * 滚动数组，两个变量
	 * 时间复杂度 n
	 * 空间复杂度 1
	 * @param n
	 * @return
	 */
    public int climbStairs(int n) {
    	if (n < 3) {
			return n;
		}
    	int first = 1, second = 2;
    	for (int i = 3; i <= n; i++) {
			second = first + second;
			first = second - first;
		}
    	return second;
    }

    /**
     * test
     * @param args
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_70_爬楼梯2 cs = new _70_爬楼梯2();
		int cs1 = cs.climbStairs(2);
		int cs2 = cs.climbStairs(3);
		System.out.println(cs1 + "_" + cs2);
	}

}
