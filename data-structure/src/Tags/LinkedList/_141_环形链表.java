package Tags.LinkedList;
/**
 * https://leetcode.cn/problems/linked-list-cycle/
 * @author csy
 *
 */
public class _141_环形链表 {
    /**
    快慢指针
    */
	/**
	 * 快慢指针
	 * 时间复杂度 O（n）
	 * 空间复杂度 O（1）
	 * @param head
	 * @return
	 */
   public boolean hasCycle(ListNode head) {
       if (head == null || head.next == null) { return false; }

       ListNode slow = head;
       ListNode fast = head.next;

       while (fast != null && fast.next != null) {
           slow = slow.next;
           fast = fast.next.next;

           if (slow == fast) { return true; }
       }

       return false;
   }
}
