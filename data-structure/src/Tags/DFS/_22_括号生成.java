package Tags.DFS;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 * @author csy
 *
 */
/**
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
示例 1：
输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]
示例 2：
输入：n = 1
输出：["()"]
提示：
1 <= n <= 8
*/
public class _22_括号生成 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n < 0) return list;
        dfs(0, n, n, new char[n << 1], list);
        return list;
    }

    /**
     *
     * @param idx 搜索的层号
     * @param leftRemain 左括号的剩余数量
     * @param rightRemain 右括号的剩余数量
     * @param string 用来存放每一层的选择
     */
    private void dfs(int idx, int leftRemain, int rightRemain,
                     char[] string, List<String> list) {
        if (idx == string.length) {
            list.add(new String(string));
            return;
        }

        // 枚举这一层所有可能的选择
        // 选择一种可能之后，进入下一层搜索

        // 什么情况可以选择左括号？左括号的数量 > 0
        // 选择左括号，然后进入下一层搜索
        if (leftRemain > 0) {
            string[idx] = '(';
            dfs(idx + 1, leftRemain - 1, rightRemain, string, list);
        }

        // 当左括号、右括号的数量一样时，只能选择左括号
        // 什么情况可以选择右括号？(右括号的数量 > 0) && (右括号的数量 != 左括号的数量)
        // 选择右括号，然后进入下一层搜索
        if (rightRemain > 0 && leftRemain != rightRemain) {
            string[idx] = ')';
            dfs(idx + 1, leftRemain, rightRemain - 1, string, list);
        }
    }

    public static void main(String[] args) {
        _22_括号生成 o = new _22_括号生成();
        System.out.println(o.generateParenthesis(3));
    }
}
