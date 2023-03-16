package Recursion;

/**
 * https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 * @author csy
 *
 */
public class _剑指_Offer_10_II_青蛙跳台阶问题2 {

	/**
	 * 滚动数组，两个变量
	 * (first + second) % 1000_000_007，大数越界处理
	 * 时间复杂度 n
	 * 空间复杂度 1
	 * @param n
	 * @return
	 */
    public int numWays(int n) {
    	if (n == 0) {
			return 1;
		} else if (n < 3) {
			return n;
		}
    	int first = 1, second = 2;
    	for (int i = 3; i <= n; i++) {
    		int third = (first + second) % 1000_000_007;
    		first = second;
    		second = third;
		}
    	return second;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_剑指_Offer_10_II_青蛙跳台阶问题2 nw = new _剑指_Offer_10_II_青蛙跳台阶问题2();
		int nw1 = nw.numWays(2);
		int nw2 = nw.numWays(7);
		int nw3 = nw.numWays(44); // 134903163
		System.out.println(nw1 + "_" + nw2 + "_" + nw3); // 2_21_1134903170
	}

}
