package Recursion;

/**
 * https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 * @author csy
 *
 */
public class _剑指_Offer_10_II_青蛙跳台阶问题2 {

	/**
	 * 滚动数组，两个变量
	 * 时间复杂度 n
	 * 空间复杂度 1
	 * @param n
	 * @return
	 */
    public int numWays(int n) {
    	if (n <= 2) {
			return n;
		}
    	int first = 1, second = 2;
    	for (int i = 3; i <= n; i++) {
			second = first + second;
			first = second - first;
		}
    	return second;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_剑指_Offer_10_II_青蛙跳台阶问题2 nw = new _剑指_Offer_10_II_青蛙跳台阶问题2();
		int nw1 = nw.numWays(2);
		int nw2 = nw.numWays(7);
		System.out.println(nw1 + "_" + nw2);
	}

}
