package Tags.String;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] words = {"abcde", "hello", "apple", "kite", "padle"};
		for (String word : words) {
			boolean wordA =  _面试题_01_01_判定字符是否唯一.isUniqueA(word);
			boolean wordB =  _面试题_01_01_判定字符是否唯一.isUniqueB(word);
			if (wordA == wordB) {
				System.out.println(word + ": " + wordA);
			} else {
				System.out.println(word + ": " + wordA + " vs " + wordB);
			}
		}
	}

}
