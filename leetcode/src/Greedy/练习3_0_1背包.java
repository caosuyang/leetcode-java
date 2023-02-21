package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
有 n 件物品和一个最大承重为 W 的背包，每件物品的重量是 𝑤i、价值是 𝑣i 在保证总重量不超过 W 的前提下，将哪几件物品装入背包，可以使得背包的总价值最大？
注意：每个物品只有 1 件，也就是每个物品只能选择 0 件或者 1 件，因此称为 0-1背包问题
◼ 如果采取贪心策略，有3个方案
① 价值主导：优先选择价值最高的物品放进背包
② 重量主导：优先选择重量最轻的物品放进背包
③ 价值密度主导：优先选择价值密度最高的物品放进背包（价值密度 = 价值 ÷ 重量）
 * @author myfolders
 *
 */
public class 练习3_0_1背包 {

	static void put(String title, int totalWeight, Article[] articles, Comparator<Article> comparator) {
		Arrays.sort(articles, comparator);
		int weight = 0, value = 0;
		List<Article> selArticles = new ArrayList<>();
		for (int i = 0; i < articles.length && weight < totalWeight; i++) {
			Article curArticle = articles[i];
			int curWieight = curArticle.weight;
			int curVlaue = curArticle.value;
			int newWeight = weight + curWieight;
			if (newWeight <= totalWeight) {
				selArticles.add(curArticle);
				weight = newWeight;
				value += curVlaue;
			}
		}
		
		System.out.println("-----------------" + title + "-----------------");
		System.out.println("总价值：" + value);
		for (Article article : selArticles) {
			System.out.println(article);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int totalWeight = 150;
		Article[] articles = new Article[] {
				new Article(35, 10), new Article(30, 40),
				new Article(60, 30), new Article(50, 50),
				new Article(40, 35), new Article(10, 40),
				new Article(25, 30)
		};
		put("重量主导", totalWeight, articles,  (Article a1, Article a2) -> {
			// 重量从小到大
			return a1.weight - a2.weight;
		});
		put("价值主导", totalWeight, articles,  (Article a1, Article a2) -> {
			// 价值从大到小
			return a2.value - a1.value;
		});
		put("价值密度主导", totalWeight, articles,  (Article a1, Article a2) -> {
			// 价值密度从大到小
			return Double.compare(a2.valueDensity, a1.valueDensity);
		});
	}

}
