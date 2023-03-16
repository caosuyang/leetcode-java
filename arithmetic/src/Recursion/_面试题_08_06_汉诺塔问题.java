package Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/hanota-lcci/
 * @author csy
 *
 */
public class _面试题_08_06_汉诺塔问题 {
	
	/**
	 * 递归
	 * 时间复杂度 n^2
	 * 空间复杂度 n
	 * @param A
	 * @param B
	 * @param C
	 */
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
    	hanota(A.size(), A, B, C);
    }
    
    /**
     * 将n个圆盘从a移动到c
     * @param n
     * @param A
     * @param B
     * @param C
     */
    public void hanota(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
    	if (n < 2) {
    		move(A, C);
		} else {
			hanota(n - 1, A, C, B);
			move(A, C);
			hanota(n - 1, B, A, C);
		}
    }
    
    /**
     * 将最顶部元素从from移动到to
     * 注意：此处处理元素挪动，index应该是 from.size() - 1，而不是 n 圆盘个数
     * @param n
     * @param A
     * @param C
     */
    public void move(List<Integer> from, List<Integer> to) {
    	int e = from.remove(from.size() - 1);
    	to.add(e);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> a = new ArrayList<>();
		a.add(2);
		a.add(1);
		a.add(0);
		List<Integer> b = new ArrayList<>();
		List<Integer> c = new ArrayList<>();
		_面试题_08_06_汉诺塔问题 h = new _面试题_08_06_汉诺塔问题();
		h.hanota(a, b, c);
		System.out.println("a: --------------");
		for (Integer i : a) {
			System.out.println(i);
		}
		System.out.println("b: --------------");
		for (Integer i : b) {
			System.out.println(i);
		}
		System.out.println("c: --------------");
		for (Integer i : c) {
			System.out.println(i);
		}
	}

}
