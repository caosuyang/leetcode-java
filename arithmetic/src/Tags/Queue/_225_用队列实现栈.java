package Tags.Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/implement-queue-using-stacks/description/
 * @author csy
 *
 */
public class _225_用队列实现栈 {
	/**
	 * 队列
	 * 空间复杂度：O(n)
	 */
	Queue<Integer> outQueue; // 用于存储栈内元素
	Queue<Integer> inQueue;  // 作为入栈操作辅助队列
	
	/**
	 * 构造函数
	 */
    public _225_用队列实现栈() {
    	outQueue = new LinkedList<Integer>();
    	inQueue = new LinkedList<Integer>();
    }
    
    /**
     * 将元素 x 压入栈顶
     * 时间复杂度：O(n)
     * @param x
     */
    public void push(int x) {
    	// 1.首先将元素入队到inQueue
    	inQueue.offer(x);
    	// 2.然后将outQueue所有元素出队，入队到inQueue
    	while (outQueue.isEmpty() == false) {
    		Integer p = outQueue.poll();
			inQueue.offer(p);
		}
    	// 3.再将outQueue和inQueue互换
    	Queue<Integer> tmpQueue = outQueue;
    	outQueue = inQueue;
    	inQueue = tmpQueue;
    }
    
    /**
     * 移除并返回栈顶元素
     * 时间复杂度：O(1)
     * @return
     */
    public int pop() {
    	return outQueue.poll();
    }
    
    /**
     * 返回栈顶元素
     * 时间复杂度：O(1)
     * @return
     */
    public int top() {
    	return outQueue.peek();
    }
    
    /**
     * 如果栈是空的，返回 true ；否则，返回 false
     * 时间复杂度：O(1)
     * @return
     */
    public boolean empty() {
    	return outQueue.isEmpty();
    }
}

///**
// * 一个队列
// */
//public class MyStack {
//	/**
//	 * 队列
//	 * 空间复杂度：O(n)
//	 */
//	Queue<Integer> queue;
//	
//	/**
//	 * 构造函数
//	 */
//    public MyStack() {
//    	queue = new LinkedList<Integer>();
//    }
//    
//    /**
//     * 将元素 x 压入栈顶
//     * 时间复杂度：O(n)
//     * @param x
//     */
//    public void push(int x) {
//        // 1.首先获取入栈前queue元素数量
//    	int size = queue.size();
//        // 2.然后将元素入队到queue
//    	queue.offer(x);
//        // 2.然后将queue前size个元素出队，入队到queue
//    	while (size-- > 0) {
//			Integer p = queue.poll();
//			queue.offer(p);
//		}
//    }
//    
//    /**
//     * 移除并返回栈顶元素
//     * 时间复杂度：O(1)
//     * @return
//     */
//    public int pop() {
//    	return queue.poll();
//    }
//    
//    /**
//     * 返回栈顶元素
//     * 时间复杂度：O(1)
//     * @return
//     */
//    public int top() {
//    	return queue.peek();
//    }
//    
//    /**
//     * 如果栈是空的，返回 true ；否则，返回 false
//     * 时间复杂度：O(1)
//     * @return
//     */
//    public boolean empty() {
//    	return queue.isEmpty();
//    }
//}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */