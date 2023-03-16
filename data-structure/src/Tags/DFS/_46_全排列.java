package Tags.DFS;

import java.util.List;
import java.util.ArrayList;

/**
 * 回溯
 * https://leetcode-cn.com/problems/permutations/
 * @author csy
 *
 */
/**
给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
示例 1：
输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
示例 2：
输入：nums = [0,1]
输出：[[0,1],[1,0]]
示例 3：
输入：nums = [1]
输出：[[1]]
提示：
1 <= nums.length <= 6
-10 <= nums[i] <= 10
nums 中的所有整数 互不相同
*/
public class _46_全排列 {
	private List<List<Integer>> list;
	private int[] nums;
	// 用来保存每一层选择的数字
	private int[] result;
	// 用来标记nums中的数字是否被使用过了
	private boolean[] used;
	
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) return null;
        list = new ArrayList<>();
        if (nums.length == 0) return list;
        this.nums = nums;
        result = new int[nums.length];
        used = new boolean[nums.length];
        dfs(0);
        return list;
    }
    
    private void dfs(int idx) {
        // 不能再往下搜索
        if (idx == nums.length) {
            List<Integer> resultList = new ArrayList<>();
            for (int value : result) {
                resultList.add(value);
            }
            list.add(resultList);
            return;
        }

        // 枚举这一层所有可以做出的选择
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            result[idx] = nums[i];
            used[i] = true;

            dfs(idx + 1);

            // 还原现场
            used[i] = false;
        }
    }
}
