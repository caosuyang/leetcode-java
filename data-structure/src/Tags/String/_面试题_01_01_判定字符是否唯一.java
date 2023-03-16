package Tags.String;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/is-unique-lcci/
 * @author csy
 *
 */
public class _面试题_01_01_判定字符是否唯一 {
	
	/**
	 * A.构建数组
	 * 第一种解法是构建一个布尔值的数组，索引值i对应的标记指示该字符串是否含有字母表第i个字符。若这个字符第二次出现，则立即返回false。
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param astr
	 * @return
	 */
   public static boolean isUniqueA(String astr) {
       int len = astr.length();
       // 上面的字符串是ASCII字符串还是Unicode字符串，这里假定字符集为ASCII
       if (len > 128) {
			return false;
	   }
       boolean[] chars = new boolean[128];
       for (int i = 0; i < len; i++) {
			int val = astr.charAt(i);
			if (chars[val]) {
				return false;
			}
			chars[val] = true;
		}
       return true;
   }
   
   /**
    * B.位向量（bit vector）???
    * 下面的代码假定字符串只含有小写字母a到z。这样一来只需使用一个int型变量。
    * 使用位向量（bit vector），可以将空间占用减少为原先的1/8。
    * @param str
    * @return
    */
	public static boolean isUniqueB(String str) {
		if (str.length() > 26) { // Only 26 characters
			return false;
		}
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) return false;
			checker |= (1 << val);
		}
		return true;
	}
	
	/**
	 * C.暴力法
	 * 如果不能使用其他数据结构，我们可以执行以下操作。(1) 将字符串中的每一个字符与其余字符进行比较。这种方法的时间复杂度为O(n^2)，空间复杂度为O(1)。
	 * @param astr
	 * @return
	 */
    public static boolean isUniqueC(String astr) {
    	int len = astr.length();
        if (len > 128) {
 			return false;
 	    }
    	for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len - i; j++) {
				int val1 = astr.charAt(i);
				int val2 = astr.charAt(j);
				if (val1 == val2) {
					return false;
				}
			}
		}
        return true;
    }
    
    /**
     * D.先排序
     * (2) 若允许修改输入字符串，可以在O(nlog(n))的时间复杂度内对字符串进行排序，然后线性检查其中有无相邻字符完全相同的情况。不过，值得注意的是，很多排序算法会占用额外的空间。
     * @param astr
     * @return
     */
    public static boolean isUniqueD(String astr) {
    	char[] chars = astr.toCharArray();
    	int len = chars.length;
        if (len > 128) {
        	return false;
 		}
    	Arrays.sort(chars);
    	for (int i = 0; i < len - 1; i++) {
			int val1 = chars[i];
			int val2 = chars[i + 1];
			if (val1 == val2) {
				return false;
			}
		}
        return true;
    }
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] words = {"leetcode", "abc"};
//		String[] words = {"abcde", "hello", "apple", "kite", "padle"};
		for (String word : words) {
			System.out.println(word + ": " + isUniqueA(word));
		}
	}

}