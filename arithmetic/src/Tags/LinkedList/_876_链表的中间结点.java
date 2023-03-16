package Tags.LinkedList;
/**
 * https://leetcode.cn/problems/middle-of-the-linked-list/description/
 * @author csy
 *
 */
public class _876_链表的中间结点 {
	/**
	 * 数组
	 * 时间复杂度：O（n）
	 * 空间复杂度：O（1）
	 * @param head
	 * @return
	 */
    public ListNode middleNode(ListNode head) {
        ListNode[] nodes = new ListNode[100];
        int i = 0;
        while (head != null) {
            nodes[i] = head;
            i++;
            head = head.next;
        }
        int mid = i / 2;
        return nodes[mid];
    }

    /**
     * 两次遍历
	 * 时间复杂度：O（n）
	 * 空间复杂度：O（1）
     * @param head
     * @return
     */
    public ListNode middleNode1(ListNode head) {
        int i = 0;
        ListNode tmp = head;
        while (tmp != null) {
            i++;
            tmp = tmp.next;
        }
        int j = 0;
        while (j < i / 2) {
            j++;
            head = head.next;
        }
        return head;
    }
	
    /**
     * 快慢指针
	 * 时间复杂度：O（n）
	 * 空间复杂度：O（1）
     * @param head
     * @return
     */
    public ListNode middleNode2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
		}
        return slow;
    }
}
