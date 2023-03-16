package 字符串;

/**
 * https://leetcode-cn.com/problems/string-rotation-lcci/
 * @author csy
 *
 */
public class 面试题_01_09_字符串轮转 {
    public boolean isFlipedString(String s1, String s2) {
    	if (s1 == null || s2 == null) return false;
    	if (s1.length() != s2.length()) return false;
    	
    	return (s1 + s1).contains(s2);
    }
}
