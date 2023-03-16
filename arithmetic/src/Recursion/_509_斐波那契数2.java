package Recursion;

/**
 * https://leetcode.cn/problems/fibonacci-number/description/
 * @author myfolders
 *
 */
public class _509_斐波那契数2 {
	/**
	 * 数组
	 * 时间复杂度 n
	 * 空间复杂度 n
	 * @param n
	 * @return
	 */
    public int fib(int n) {
    	if (n < 2) {
			return n;
		}
    	int[] array = new int[n + 1];
    	array[1] = array[2] = 1;
    	return fib(array, n);
    }
    
    public int fib(int[] array, int n) {
		if (array[n] == 0) {
			array[n] = fib(array, n - 1) + fib(array, n - 2);
		}
		return array[n];
	}

    /**
     * test
     * @param args
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		_509_斐波那契数2 fib = new _509_斐波那契数2();
		int f1 = fib.fib(0);
		int f2 = fib.fib(1);
		int f3 = fib.fib(2);
		int f4 = fib.fib(3);
		int f5 = fib.fib(4);
		System.out.println(f1 + "_" + f2 + "_" + f3 + "_" + f4 + "_" + f5);
	}

}
