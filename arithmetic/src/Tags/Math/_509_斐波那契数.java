package Tags.Math;
/**
 * https://leetcode.cn/problems/fibonacci-number/description/
 * @author csy
 *
 */
public class _509_斐波那契数 {
	/**
	 * 递归
	 * 时间复杂度：O(2^n)
	 * 空间复杂度：O(n)
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
     * 动态规划
     * 只需要前两个元素，用滚动数组替代
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param n
     * @return
     */
    public int fib2(int n) {
    	if (n < 2) {
			return n;
		}
    	int first = 0;
    	int second = 1;
    	while (n-- > 1) {
			second += first;
			first = second - first;
		}
    	return second;
    }
    
    /**
     * test
     * @param args
     */
    public static void main(String[] args) {
    	_509_斐波那契数 o = new _509_斐波那契数();
        System.out.println(o.fib(2) == 1);
        System.out.println(o.fib(3) == 2);
        System.out.println(o.fib(4) == 3);

        System.out.println(o.fib2(2) == 1);
        System.out.println(o.fib2(3) == 2);
        System.out.println(o.fib2(4) == 3);
    }
}