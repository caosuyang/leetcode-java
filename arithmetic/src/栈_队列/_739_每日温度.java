package 栈_队列;

/**
 * https://leetcode-cn.com/problems/daily-temperatures/
 * @author csy
 *
 */
public class _739_每日温度 {
    public int[] dailyTemperatures(int[] T) {
    	if (T == null || T.length == 0) return null;
    	int[] values = new int[T.length];
    	for (int i = T.length - 2; i >= 0; i--) {
			int j = i + 1;
			while (true) {
				if (T[i] < T[j]) {
					values[i] = j - i;
					break;
				} else if (values[j] == 0) {
					values[i] = 0;
					break;
				}
				
				j = j + values[j];
			}
		}
    	return values;
    }
}
