package Tags.Sort;

import common.ListNode;

/**
 * https://leetcode.cn/problems/merge-two-sorted-lists/description/
 * @author csy
 *
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class _21_合并两个有序链表 {
	/**
	 * 排序，虚拟头节点
	 * @param list1
	 * @param list2
	 * @return
	 */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    	if (list1 == null) {
			return list2;
		}
    	if (list2 == null) {
			return list1;
		}
    	ListNode head = new ListNode(0);
    	ListNode cur = head;
    	while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				cur = cur.next = list1;
				list1 = list1.next;
			} else {
				cur = cur.next = list2;
				list2 = list2.next;
			}
		}
    	if (list1 == null) {
			cur.next = list2;
		}
    	if (list2 == null) {
			cur.next = list1;
		}
    	return head.next;
    }
}
