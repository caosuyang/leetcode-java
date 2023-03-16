package 栈_队列;

/**
 * https://leetcode-cn.com/problems/min-stack/
 * @author csy
 *
 */
public class _155_最小栈 {
	private Node head;
	
	/** initialize your data structure here. */
	public _155_最小栈() {
		head = new Node(0, Integer.MAX_VALUE, null);
	}
	
	public void push(int val) {
		head = new Node(val, Math.min(val, head.min), head);
	}
	
	public void pop() {
		head = head.next;
	}
	
	public int top() {
		return head.val;
	}
	
	public int getMin() {
		return head.min;
	}
	
	private static class Node {
		public int val;
		public int min;
		public Node next;
		public Node(int val, int min, Node next) {
			this.val = val;
			this.min = min;
			this.next = next;
		}
	}
	
}
