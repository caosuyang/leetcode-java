package Recursion;

/**
 * https://leetcode.cn/problems/fibonacci-number/description/
 * @author myfolders
 *
 */
public class _509_斐波那契数5 {
	/**
	 * 滚动数组，位运算
	 * 时间复杂度 n
	 * 空间复杂度 1
	 * @param n
	 * @return
	 */
    public int fib(int n) {
    	if (n < 2) {
			return n;
		}
    	int[] array = new int[2];
    	array[0] = array[1] = 1;
    	for (int i = 3; i <= n; i++) {
    		array[i & 1] = array[(i - 1) & 1] + array[(i - 2) & 1];
		}
    	return array[n & 1];
    }

    /**
     * test
     * @param args
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		_509_斐波那契数5 fib = new _509_斐波那契数5();
		int f1 = fib.fib(0);
		int f2 = fib.fib(1);
		int f3 = fib.fib(2);
		int f4 = fib.fib(3);
		int f5 = fib.fib(4);
		System.out.println(f1 + "_" + f2 + "_" + f3 + "_" + f4 + "_" + f5);
	}

}
