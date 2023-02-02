package Tags.Stack;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/score-of-parentheses/
 * @author csy
 *
 */
public class _856_括号的分数 {
	/**
	 * 栈
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @param s
	 * @return
	 */
    public int scoreOfParentheses(String s) {
    	Stack<Integer> stack = new Stack<>();
    	stack.push(0);
    	int len = s.length();
    	
    	for (int i = 0; i < len; i++) {
    		char c = s.charAt(i);
			if (c == '(') { // 左括号
				stack.push(0);
			} else { // 右括号
				// 将右括号内的子平衡括号字符串A的分数弹出
				int a = stack.pop();
				if (a == 0) {// 子平衡括号字符串A是空串，(A)的分数是1
					stack.push(stack.pop() + 1);
				} else {// 子平衡括号字符串A不是空串，(A)的分数是2*a
					stack.push(stack.pop() + 2 * a);
				}
			}
		}
    	return stack.peek();
    }
}
