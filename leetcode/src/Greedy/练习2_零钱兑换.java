package Greedy;

import java.util.Arrays;

/**
 假设有 25 分、10 分、5 分、1 分的硬币，现要找给客户 41 分的零钱，如何办到硬币个数最少？
◼ 贪心策略：每一次都优先选择面值最大的硬币
① 选择 25 分的硬币，剩 16 分 ② 选择 10 分的硬币，剩 6 分 ③ 选择 5 分的硬币，剩 1 分 ④ 选择 1 分的硬币
最终的解是共 4 枚硬币
✓ 25 分、10 分、5 分、1 分硬币各一枚
 * @author myfolders
 *
 */
public class 练习2_零钱兑换 {
	/**
	 * 贪心策略：每一次都优先选择面值最大的硬币
	 * @param money
	 * @param faces
	 * @return 最少硬币个数
	 */
	public int minCount(int money, int[] faces) {
		int count = 0, coin = 0;
		// 从小到大
		Arrays.sort(faces);
		for (int i = faces.length - 1; i >= 0 && coin < money; i--) {
			int curCoin = faces[i];
			int newCoin = coin + curCoin;
			if (newCoin <= money) {
				coin = newCoin;
				count++;
			}
		}
		return count;
	}
	
	/**
	 * 贪心策略：每一次都优先选择面值最大的硬币
	 * @param money
	 * @param faces
	 * @return 最少的硬币
	 */
	public int[] newCoins(int money, int[] faces) {
		int coin = 0;
		int[] newCoins = new int[faces.length];
		// 从小到大
		Arrays.sort(faces);
		int idx = 0;
		for (int i = faces.length - 1; i >= 0 && coin < money; i--) {
			int curCoin = faces[i];
			int newCoin = coin + curCoin;
			if (newCoin <= money) {
				newCoins[idx++] = curCoin;
				coin = newCoin;
			}
		}
		return newCoins;
	}
	
	/**
	 * 贪心策略：每一次都优先选择面值最大的硬币
	 * @param money
	 * @param faces
	 * @return 最少硬币个数
	 */
	public int minCount1(int money, int[] faces) {
		// 从小到大
		Arrays.sort(faces);
		
		int count = 0, idx = faces.length - 1;
		
		while (idx >= 0) {
			while (money >= faces[idx]) {
				money -= faces[idx];
				count++;
			}
			idx--;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int money = 41;
		int[] faces = {25, 10, 5, 1};
		练习2_零钱兑换 mc = new 练习2_零钱兑换();
		int count = mc.minCount(money, faces);
		System.out.println(count);
		
		System.out.println("======================");
		int count1 = mc.minCount(money, faces);
		System.out.println(count1);
		
		System.out.println("======================");
		int[] newCoins = mc.newCoins(money, faces);
		for (int i : newCoins) {
			if (i > 0 ) {
				System.out.println(i);
			}
		}
		
		System.out.println("======================");
		int[] faces2 = {25, 20, 5, 1};
		int count2 = mc.minCount(money, faces2);
		System.out.println(count2);
		
		System.out.println("======================");
		int count3 = mc.minCount(money, faces2);
		System.out.println(count3);
		
		System.out.println("======================");
		int[] newCoins1 = mc.newCoins(money, faces2);
		for (int i : newCoins1) {
			if (i > 0 ) {
				System.out.println(i);
			}
		}
	}

}
