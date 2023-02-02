package Tags.String;

/**
 * https://leetcode-cn.com/problems/string-to-url-lcci/
 * @author csy
 *
 */
public class _面试题_01_03_URL化 {

	/**
	 * A.字符数组
	 * @param S
	 * @param length
	 * @return
	 */
    public static String replaceSpaces(String S, int length) {
    	char[] chars1 = S.toCharArray();
    	int count = 0;
    	for (int i = 0; i < length; i++) {
			char c = chars1[i];
			if (c == ' ') {
				count++;
			}
		}
    	int len = length + count * 2;
    	char[] chars2 = new char[len];
    	for (int i = length - 1; i >= 0; i--) {
    		char c = chars1[i];
			if (c == ' ') {
				// %20
				chars2[len - 1] = '0';
				chars2[len - 2] = '2';
				chars2[len - 3] = '%';
				len -= 3;
			} else {
				chars2[len - 1] = c;
				len--;
			}
		}
    	String string = new String(chars2);
    	return string;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "Mr John Smith    ";
		int length = 13;
		System.out.println(replaceSpaces(str, length));
	}
}
