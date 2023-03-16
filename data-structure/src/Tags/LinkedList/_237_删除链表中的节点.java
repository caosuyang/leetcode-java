package Tags.LinkedList;
/**
 * https://leetcode.cn/problems/delete-node-in-a-linked-list/
 * @author csy
 *
 */
public class _237_删除链表中的节点 {
	/**
	 * 从尾部合并到头部以避免覆盖
	 * 时间复杂度：O（n）
	 * 空间复杂度：O（1）
	 * @param node
	 */
    public void deleteNode(ListNode node) {
    	node.val = node.next.val;
    	node.next = node.next.next;
    }
}
