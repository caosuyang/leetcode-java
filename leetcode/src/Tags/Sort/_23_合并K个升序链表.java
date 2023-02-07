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
	 * 数组，排序
	 * 时间复杂度：O(nlogn)
	 * 空间复杂度：O(n)
	 * @param lists
	 * @return
	 */
    public ListNode mergeKLists(ListNode[] lists) {
    	if (lists == null || lists.length == 0) {
			return null;
		}
    	List<ListNode> nodes = new ArrayList<>();
    	for (ListNode node : lists) {
    		while (node != null) {
				nodes.add(node);
				node = node.next;
			}
		}
    	Comparator<ListNode> comparator = (ListNode node1, ListNode node2) -> {
    		return node1.val - node2.val;
    	};

    	nodes.sort(comparator);
    	ListNode head = new ListNode(0);
    	ListNode cur = head;
    	for (ListNode node : nodes) {
			cur = cur.next = node;
		}
    	return head.next;
    }
}
