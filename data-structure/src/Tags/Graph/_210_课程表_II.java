package Tags.Graph;

/**
 * https://leetcode.cn/problems/course-schedule-ii/description/
 * @author csy
 *
 */
public class _210_课程表_II {
	/**
	 * 类似与基数排序
	 * 输入：numCourses = 4, prerequisites = [[3,1],[2,1],[2,0],[3,2]]
	 * 输出：[1,0,2,3]、[1,2,0,3]
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
    	int[] orders = new int[numCourses];
    	if (numCourses == 1 || prerequisites == null) {
    		orders[0] = 0;
			return orders;
		} // [0]
    
    	// 开辟内存空间，存储先完成课程次数
    	int counts[] = new int[numCourses];
    	for (int i = 0; i < prerequisites.length - 1; i++) {
    		int index = prerequisites[i][1];
    		counts[index]++;
		} // [1, 2, 1, 0]
    	
    	// 计算权重这种方式不行，因为相同权重的值依旧有先后
    	// 此路不通
    	return orders;
    }
	
	/**
	 * 拓扑排序
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
    public int[] findOrder1(int numCourses, int[][] prerequisites) {
    	return null;
    }

    /**
     * test
     * @param args
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
