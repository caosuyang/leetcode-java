package String;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/check-permutation-lcci/
 * @author csy
 *
 */
public class _面试题_01_02_判定是否互为字符重排 {
	
	/**
	 * A.排序
	 * @param s1
	 * @param s2
	 * @return
	 */
    public static boolean CheckPermutationA(String s1, String s2) {
    	char[] chars1 = s1.toCharArray();
    	char[] chars2 = s2.toCharArray();
    	if (chars1.length != chars2.length) {
			return false;
		}
    	Arrays.sort(chars1);
    	Arrays.sort(chars2);
    	return chars1 == chars2;
    }
    
	/**
	 * B.哈希表
	 * @param s1
	 * @param s2
	 * @return
	 */
    public static boolean CheckPermutationB(String s1, String s2) {
    	if (s1.length() != s2.length()) {
			return false;
		}
    	int[] chars = new int[128];
    	for (int i = 0; i < s1.length(); i++) {
    		chars[s1.charAt(i)]++;
		}
    	for (int j = 0; j < s2.length(); j++) {
    		chars[s1.charAt(j)]--;
    		if (chars[s1.charAt(j)] < 0) {
				return false;
			}
		}
    	return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
