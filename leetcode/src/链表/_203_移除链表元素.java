package 链表;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * @author myfolders
 *
 */
public class _203_移除链表元素 {
//	// 虚拟头结点
//	public ListNode removeElements(ListNode head, int val) {
//		// 创建一个虚拟头结点，数据域象征性给-1
//        ListNode dummyHead = new ListNode(-1);
//        dummyHead.next = head;
//        
//        // 此时链表中所有节点都有前驱节点
//        ListNode prev = dummyHead;
//        while (prev.next != null) {
//			if (prev.next.val == val) {
//				prev.next = prev.next.next;
//			} else {
//				prev = prev.next;
//			}
//		}
//        return dummyHead.next;
//    }
//	
//	// 递归
//	public ListNode removeElements1(ListNode head, int val) {
//		if (head == null) return head;
//		head.next = removeElements(head.next, val);
//        return head.val == val ? head.next : head;
//    }
	
//    public ListNode removeElements(ListNode head, int val) {
//    	if (head == null) return null;
//    	
//    	ListNode newHead = null;
//    	ListNode newTail = null;
//    	while (head != null) {
//    		if (head.val != val) {
//        		if (newTail == null) {
//        			newHead = head;
//        			newTail = head;
//        		} else {
//        			newTail.next = head;
//        			newTail = head;
//        		}
//    		}
//    		head = head.next;
//    	}
//    	
//		if (newTail == null) {
//			return null;
//		} else {
//			newTail.next = null;
//		}
//		return newHead;
//    }
	/**
	 * 虚拟头结点
	 * @param head
	 * @param val
	 * @return
	 */
    public ListNode removeElements(ListNode head, int val) {
    	if (head == null) return null;
    	
    	// 新链表的头结点
    	ListNode newHead = new ListNode(0);
    	// 新链表的尾结点
    	ListNode newTail = newHead;
    	while (head != null) {
    		if (head.val != val) {
    			newTail.next = head;
    			newTail = head;
    		}
    		head = head.next;
    	}
    	newTail.next = null;
		return newHead.next;
    }
}
