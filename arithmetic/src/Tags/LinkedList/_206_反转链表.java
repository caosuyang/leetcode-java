package Tags.LinkedList;
/**
 * https://leetcode.cn/problems/reverse-linked-list/
 * @author csy
 *
 */
public class _206_反转链表 {
	/**
	 * 递归
	 * 时间复杂度：O（n）
	 * 空间复杂度：O（1）
	 * @param head
	 * @return
	 */
    public ListNode reverseList(ListNode head) {
        return reverseList(null, head);
    }

    public ListNode reverseList(ListNode prev, ListNode cur) {
        if (cur == null) { return prev; }

        ListNode next = cur.next;
        cur.next = prev;

        return reverseList(cur, next);

    }

    /**
     * 迭代+三指针
     * 时间复杂度：O（n）
     * 空间复杂度：O（1）
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) { return head; }

        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;

            prev = cur;
            cur = next;
        }
        return prev;
    }
}
