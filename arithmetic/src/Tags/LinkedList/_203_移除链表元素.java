package Tags.LinkedList;
/**
 * https://leetcode.cn/problems/remove-linked-list-elements/description/
 * @author csy
 *
 */
public class _203_移除链表元素 {
	/**
	 * 递归
	 * 时间复杂度：O（2^n）
	 * 空间复杂度：O（n）
	 * @param head
	 * @param val
	 * @return
	 */
    public ListNode removeElements(ListNode head, int val) {
    	if (head == null) {
			return head;
		}
    	
    	head.next = removeElements(head.next, val);    	
    	return head.val == val ? head.next : head;
    }
    
	/**
	 * 迭代
	 * 时间复杂度：O（n）
	 * 空间复杂度：O（n）
	 * @param head
	 * @param val
	 * @return
	 */
    public ListNode removeElements1(ListNode head, int val) {
    	ListNode newHead = new ListNode(0);
    	newHead.next = head;
    	ListNode tmp = newHead;
    	
    	while (tmp.next != null) {
			if (tmp.next.val == val) {
				tmp.next = tmp.next.next;
			} else {
				tmp = tmp.next;
			}
		}
    	return newHead.next;
    }
}
