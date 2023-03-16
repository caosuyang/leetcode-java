package Tags.Stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * https://leetcode.cn/problems/valid-parentheses/description/
 * @author csy
 *
 */
public class _20_有效的括号 {
	private static HashMap<Character, Character> map = new HashMap<>();
	static {
    	map.put('(', ')');
    	map.put('[', ']');
    	map.put('{', '}');
	}
	
	/**
	 * 栈
	 * 时间复杂度
	 * 空间复杂度
	 * @param s
	 * @return
	 */
    public boolean isValid(String s) {
    	Stack<Character> stack = new Stack<>();
    	
    	int len = s.length();
    	for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {// 左括号
				stack.push(c);
			} else {// 右括号
				if (stack.isEmpty()) return false;
				if (c != map.get(stack.pop())) return false;
			}
		}
    	return stack.isEmpty();
    }
	
	
	/**
	 * 栈
	 * map优化
	 * 时间复杂度
	 * 空间复杂度
	 * @param s
	 * @return
	 */
    public boolean isValid1(String s) {
    	Stack<Character> stack = new Stack<>();
    	
    	int len = s.length();
    	for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (c == '(' || c == '[' || c == '{') {// 左括号
				stack.push(c);
			} else {// 右括号
				if (stack.isEmpty()) return false;
				char l = stack.pop();
				if (c != ')' && l == '(') return false;
				if (c != ']' && l == '[') return false;
				if (c != '}' && l == '{') return false;
			}
		}
    	return stack.isEmpty();
    }
    
	/**
	 * 字符替换
	 * 时间复杂度
	 * 空间复杂度
	 * @param s
	 * @return
	 */
    public boolean isValid2(String s) {
    	while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
			s = s.replace("()", "");
			s = s.replace("[]", "");
			s = s.replace("{}", "");
		}
    	return s.isEmpty();
    }
}
