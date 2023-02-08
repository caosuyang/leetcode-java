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
	 * 递归，递归基（边界），递归函数定义
	 * 时间复杂度：O(n+m)，因为n和m分别为两个链表长度，每次调用递归去掉list1或list2的头节点，知道有一个链表为null，函数mergeTwoLists至多递归调用每一个节点一次，所以时间复杂度是合并和链表的长度n+m。
	 * 空间复杂度：O(n+m)，因为n和m分别为两个链表长度，递归调用mergeTwoLists函数最多调用n+m次。
	 * @param list1
	 * @param list2
	 * @return
	 */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    	// 如果list1或list2为null，不需要合并操作，直接返回另一个
    	if (list1 == null) {
			return list2;
		}
    	if (list2 == null) {
			return list1;
		}
    	// 否则判断list1和list2哪个头节点的值较小，递归取出下一个节点给到结果的next
    	if (list1.val < list2.val) {
    		// 重要：mergeTwoLists函数，两个链表头部值较小的节点和剩下元素的merge操作结果合并
    		list1.next = mergeTwoLists(list1.next, list2);
    		return list1;
		} else {
			list2.next = mergeTwoLists(list1, list2.next);
			return list2;
		}
    }
    
	/**
	 * 迭代，虚拟头节点
	 * 时间复杂度：O(n+m)，因为n和m分别为两个链表长度，每次while中list1和list2只有一个元素放进合并链表中，所以while循环次数不超过两个链表长度和m+n，而其他操作时间复杂度都是常数级别，最终总时间复杂度为O(n+m)。
	 * 空间复杂度：O(1)，因为只需常数空间存放若干变量。
	 * @param list1
	 * @param list2
	 * @return
	 */
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
    	if (list1 == null) {
			return list2;
		}
    	if (list2 == null) {
			return list1;
		}
    	// 虚拟头节点（dummy head）
    	// 设定一个虚拟头节点，能够通过head.next比较容易的返回合并后的链表
    	ListNode head = new ListNode(0);
    	// 维护一个cur指针首先指向head
    	ListNode cur = head;
    	// 当list1和list2都不为空
    	while (list1 != null && list2 != null) {
    		// 判断哪个链表头节点值更小
			if (list1.val <= list2.val) {
				// 将较小值的节点指向cur.next，cur指针向后移一位
				cur = cur.next = list1;
				// 对应链表节点向后移动一位
				list1 = list1.next;
			} else {
				cur = cur.next = list2;
				list2 = list2.next;
			}
		}
    	// 跳出循环后，list1和list2至多只有一个没被合并完，直接将链表末尾指向未合并完的链表即可
    	if (list1 == null) {
			cur.next = list2;
		}
    	if (list2 == null) {
			cur.next = list1;
		}
    	return head.next;
    }
    

}
