package Recursion;

/**
 * https://leetcode.cn/problems/fibonacci-number/description/
 * @author myfolders
 *
 */
public class _509_斐波那契数7 {
	/**
	 * 线性代数，特征方程
	 * 时间复杂度 取决于pow，至少可以低到 logn
	 * 空间复杂度 取决于pow
	 * @param n
	 * @return
	 */
    public int fib(int n) {
    	double c = Math.sqrt(5);
    	return (int) ((Math.pow((1 + c) / 2, n) - Math.pow((1 - c) / 2, n)) / c);
    }

    /**
     * test
     * @param args
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		_509_斐波那契数7 fib = new _509_斐波那契数7();
		int f1 = fib.fib(0);
		int f2 = fib.fib(1);
		int f3 = fib.fib(2);
		int f4 = fib.fib(3);
		int f5 = fib.fib(4);
		System.out.println(f1 + "_" + f2 + "_" + f3 + "_" + f4 + "_" + f5);
	}

}
