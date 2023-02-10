package Recursion;

/**
 * https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 * @author csy
 *
 */
public class _剑指_Offer_10_II_青蛙跳台阶问题 {

	/**
	 * 递归
	 * 时间复杂度 n^2
	 * 空间复杂度 n
	 * @param n
	 * @return
	 */
    public int numWays(int n) {
    	if (n <= 2) {
			return n;
		}
    	return numWays(n - 2) + numWays(n - 1);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_剑指_Offer_10_II_青蛙跳台阶问题 nw = new _剑指_Offer_10_II_青蛙跳台阶问题();
		int nw1 = nw.numWays(2);
		int nw2 = nw.numWays(7);
		System.out.println(nw1 + "_" + nw2);
	}

}
