package Tags.Sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import common.ListNode;

/**
 * https://leetcode.cn/problems/merge-k-sorted-lists/description/
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
public class _23_合并K个升序链表 {
	/**
	 * 思路1：数组
	 * 时间复杂度：O(nlogn)
	 * 空间复杂度：O(n)
	 * @param lists
	 * @return
	 */
    public ListNode mergeKLists(ListNode[] lists) {
    	if (lists == null || lists.length == 0) {
			return null;
		}
    	// 将所有节点添加到数组nodes中
    	// O(n)
    	List<ListNode> nodes = new ArrayList<>();
    	for (ListNode node : lists) {
    		while (node != null) {
				nodes.add(node);
				node = node.next;
			}
		}
    	// 对数组中的节点从小到大进行排序
    	// O(nlogn)
    	Comparator<ListNode> comparator = (ListNode node1, ListNode node2) -> {
    		return node1.val - node2.val;
    	};
    	nodes.sort(comparator);
    	// 从数组中从小到大一次取出节点，串成链表
    	// O(n)
    	ListNode head = new ListNode(0);
    	ListNode cur = head;
    	for (ListNode node : nodes) {
			cur = cur.next = node;
		}
    	return head.next;
    }
    
	/**
	 * 思路2：逐一比较
	 * 时间复杂度：O(kn)，其中k表示k条链表，n表示每条链表有n个节点
	 * 空间复杂度：O(n)
	 * @param lists
	 * @return
	 */
    public ListNode mergeKLists1(ListNode[] lists) {
    	return null;
    }
    
	/**
	 * 思路3：逐一两两合并，利用_21_合并两个有序链表
	 * 时间复杂度：O(kn)，其中k表示k条链表，n表示每条链表有n个节点
	 * 空间复杂度：O(n)
	 * @param lists
	 * @return
	 */
    public ListNode mergeKLists2(ListNode[] lists) {
    	return null;
    }
    
	/**
	 * 迭代，虚拟头节点
	 * 时间复杂度：O(n+m)，因为n和m分别为两个链表长度，每次while中list1和list2只有一个元素放进合并链表中，所以while循环次数不超过两个链表长度和m+n，而其他操作时间复杂度都是常数级别，最终总时间复杂度为O(n+m)。
	 * 空间复杂度：O(1)，因为只需常数空间存放若干变量。
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
    
	/**
	 * 思路4：优先级队列，小顶堆
	 * 时间复杂度：O(nlogk)
	 * 空间复杂度：O(k)
	 * @param lists
	 * @return
	 */
    public ListNode mergeKLists3(ListNode[] lists) {
    	return null;
    }
    
	/**
	 * 思路5：分治，利用mergeTwoLists函数
	 * 时间复杂度：O(nlogk)
	 * 空间复杂度：O(k)
	 * @param lists
	 * @return
	 */
    public ListNode mergeKLists4(ListNode[] lists) {
    	return null;
    }
}
