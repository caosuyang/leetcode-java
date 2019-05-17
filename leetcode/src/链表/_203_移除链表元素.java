package 链表;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * @author myfolders
 *
 */
public class _203_移除链表元素 {
	// 虚拟头结点
	public ListNode removeElements(ListNode head, int val) {
		// 创建一个虚拟头结点，数据域象征性给-1
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        
        // 此时链表中所有节点都有前驱节点
        ListNode prev = dummyHead;
        while (prev.next != null) {
			if (prev.next.val == val) {
				prev.next = prev.next.next;
			} else {
				prev = prev.next;
			}
		}
        return dummyHead.next;
    }
	
	// 递归
	public ListNode removeElements1(ListNode head, int val) {
		if (head == null) return head;
		head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}
