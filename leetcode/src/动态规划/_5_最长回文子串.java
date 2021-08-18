package 动态规划;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * @author csy
 *
 */
public class _5_最长回文子串 {
	private char[] preprocess(char[] oldCs) {
		char[] cs = new char[(oldCs.length << 1) + 3];
		cs[0] = '^';
		cs[1] = '#';
		cs[cs.length - 1] = '$';
		for (int i = 0; i < oldCs.length; i++) {
			int idx = (i + 1) << 1;
			cs[idx] = oldCs[i];
			cs[idx + 1] = '#';
		}
		return cs;
	}

	/**
	 * 马拉车算法
	 */
	public String longestPalindromeManacher(String s) {
		if (s == null) return null;
		char[] oldCs = s.toCharArray();
		if (oldCs.length <= 1) return s;

		// 预处理
		char[] cs = preprocess(oldCs);
		// 构建m数组
		int[] m = new int[cs.length];
		int c = 1, r = 1, lastIdx = m.length - 2;
		int maxLen = 0, idx = 0;
		for (int i = 2; i < lastIdx; i++) {
			if (r > i) {
				int li = (c << 1) - i;
				m[i] = (i + m[li] <= r) ? m[li] : (r - i);
			}

			// 以i为中心，向左右扩展
			while (cs[i + m[i] + 1] == cs[i - m[i] - 1]) {
				m[i]++;
			}

			// 更新c、r
			if (i + m[i] > r) {
				c = i;
				r = i + m[i];
			}

			// 找出更大的回文子串
			if (m[i] > maxLen) {
				maxLen = m[i];
				idx = i;
			}
		}
		int begin = (idx - maxLen) >> 1;
		return new String(oldCs, begin, maxLen);
	}
}
