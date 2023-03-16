package Greedy;

import java.util.Arrays;

/**
◼ 在北美洲东南部，有一片神秘的海域，是海盗最活跃的加勒比海
有一天，海盗们截获了一艘装满各种各样古董的货船，每一件古董都价值连城，一旦打碎就失去了它的价值
海盗船的载重量为 W，每件古董的重量为 𝑤i，海盗们该如何把尽可能多数量的古董装上海盗船？
比如 W 为 30，𝑤i 分别为 3、5、4、10、7、14、2、11
◼ 贪心策略：每一次都优先选择重量最小的古董
① 选择重量为 2 的古董，剩重量 28
② 选择重量为 3 的古董，剩重量 25
③ 选择重量为 4 的古董，剩重量 21
④ 选择重量为 5 的古董，剩重量 16
⑤ 选择重量为 7 的古董，剩重量 9 最多能装载 5 个古董
 * @author myfolders
 *
 */
public class 练习1_最优装载问题_加勒比海盗 {
	
	/**
	 * 贪心策略：每一次都优先选择重量最小的古董
	 * @param capacity
	 * @param weights
	 * @return 尽可能多数量
	 */
	public int maxCount(int capacity, int[] weights) {
		int count = 0, weight = 0;
		// 排序后从小到大排列
		Arrays.sort(weights);
		
		for (int i = 0; i < weights.length && weight < capacity; i++) {
			int newWeight = weight + weights[i];
			if (newWeight <= capacity) {
				weight = newWeight;
				count++;
			}
		}
		
		return count;
	}
	
	/**
	 * 贪心策略：每一次都优先选择重量最小的古董
	 * @param capacity
	 * @param weights
	 * @return 最多能装载的古董
	 */
	public int[] newWeights(int capacity, int[] weights) {
		int weight = 0;
		// 排序后从小到大排列
		Arrays.sort(weights);
		int[] newWeights = new int[weights.length];
		int index = 0;
		for (int i = 0; i < weights.length && weight < capacity; i++) {
			int curWeight = weights[i];
			int newWeight = weight + curWeight;
			if (newWeight <= capacity) {
				newWeights[index++] = curWeight;
				weight = newWeight;
			}
		}
		return newWeights;
	}

	/**
	 * test
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int capacity = 30;
		int[] weights = {3, 5, 4, 10, 7, 14, 2, 11};
		练习1_最优装载问题_加勒比海盗 mc = new 练习1_最优装载问题_加勒比海盗();
		int count = mc.maxCount(capacity, weights);
		System.out.println(count);
		
		System.out.println("======================");
		int[] newWeights = mc.newWeights(capacity, weights);
		for (int i : newWeights) {
			if (i > 0 ) {
				System.out.println(i);
			}
		}
	}
}
