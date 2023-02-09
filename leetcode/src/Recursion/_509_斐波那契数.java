package Recursion;

/**
 * https://leetcode.cn/problems/fibonacci-number/description/
 * @author myfolders
 *
 */
public class _509_斐波那契数 {
	/**
	 * 递归
	 * 时间复杂度 n^2
	 * 空间复杂度 n
	 * @param n
	 * @return
	 */
    public int fib(int n) {
    	if (n < 2) {
			return n;
		}
    	return fib(n - 1) + fib(n - 2);
    }

    /**
     * test
     * @param args
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		_509_斐波那契数 fib = new _509_斐波那契数();
		int f1 = fib.fib(0);
		int f2 = fib.fib(1);
		int f3 = fib.fib(2);
		int f4 = fib.fib(3);
		int f5 = fib.fib(4);
		System.out.println(f1 + "_" + f2 + "_" + f3 + "_" + f4 + "_" + f5);
	}

}
