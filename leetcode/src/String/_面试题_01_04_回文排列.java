package String;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/palindrome-permutation-lcci/
 * @author csy
 *
 */
public class _面试题_01_04_回文排列 {

	/**
	 * A.哈希表
	 * @param s
	 * @return
	 */
    public static boolean canPermutePalindrome(String s) {
    	s = s.toLowerCase();
    	HashMap<Character, Integer> map = new HashMap<>();
    	for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (map.containsKey(c)) {
				Integer v = map.get(c);
				v += 1;
				map.put(c, v);
			} else {
				map.put(c, 1);
			}
		}
    	// { =5, a=2, r=2, s=2, t=2, e=2, v=2, i=2, l=2, n=2, o=2}
    	System.out.println(map);
    	
    	Object[] values = map.values().toArray();    	
    	int count = 0;
    	for (int i = 0; i < values.length; i++) {
			Integer vInteger = (Integer) values[i];
			if (vInteger % 2 != 0) {
				count++;
			}
		}
    	if (count > 1) {
			return false;
		}
    	return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		String pali = "Rats live on no evil star";
		String pali = "AaBb//a";
		System.out.println(canPermutePalindrome(pali));
	}

}
