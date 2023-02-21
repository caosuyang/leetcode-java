package Greedy;
/**
 * 放入背包的物品
 * @author csy
 *
 */
public class Article {
	// 重量
	public int weight;
	// 价值
	public int value;
	// 价值密度
	public double valueDensity;
	
	public Article(int weight, int value) {
		this.weight = weight;
		this.value = value;
		valueDensity = value * 1.0 / weight;
	}
	
	@Override
	public String toString() {
		return "Article [weight=" + weight + ", value=" + value + ", valueDensity=" + valueDensity + "]";
	}
}