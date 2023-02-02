package Tags.LinkedList;
/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/
 * @author csy
 *
 */
public class _83_删除排序链表中的重复元素 {
	/**
	 * 迭代
	 * 时间复杂度：O（n）
	 * 空间复杂度：O（1）
	 * @param head
	 * @return
	 */
	
	/**
	 * 一次遍历
	 * 时间复杂度：O（n）
	 * 空间复杂度：O（1）
	 * @param head
	 * @return
	 */
	
	/**
	 * 一次遍历，边界优化
	 * 时间复杂度：O（n）
	 * 空间复杂度：O（1）
	 * @param head
	 * @return
	 */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
