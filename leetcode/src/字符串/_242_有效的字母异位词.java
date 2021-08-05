package 字符串;

/**
 * https://leetcode-cn.com/problems/valid-anagram/
 * @author csy
 *
 */
public class _242_有效的字母异位词 {
	public boolean isAnagram(String s, String t) {
		if (s == null || t== null) return false;
		char[] schars = s.toCharArray();
		char[] tchars = t.toCharArray();
		int slength = schars.length;
		int tlength = tchars.length;
		if (slength != tlength) return false;
		
		int[] counts = new int[26];
		for (int i = 0; i < slength; i++) {
			counts[schars[i] - 'a']++;
		}
		for (int i = 0; i < tlength; i++) {
			if (--counts[tchars[i] - 'a'] < 0) return false;
		}
		return true;
	}
}
