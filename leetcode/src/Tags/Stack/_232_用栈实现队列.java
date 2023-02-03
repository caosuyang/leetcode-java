package Tags.Stack;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/implement-queue-using-stacks/description/
 * @author csy
 *
 */
public class _232_用栈实现队列 {
	/**
	 * 栈
	 */
	private Stack<Integer> inStack;
	private Stack<Integer> outStack;
	/**
	 * 实例化
	 */
    public _232_用栈实现队列() {
    	inStack = new Stack<>();
    	outStack = new Stack<>();
    }
    
    /**
     * 将元素 x 推到队列的末尾
     * @param x
     */
    public void push(int x) {
    	inStack.push(x);
    }
    
    /**
     * 从队列的开头移除并返回元素
     * @return
     */
    public int pop() {
    	checkOutStack();
    	return outStack.pop();
    }
    
    /**
     * 返回队列开头的元素
     * @return
     */
    public int peek() {
    	checkOutStack();
    	return outStack.peek();
    }
    
    /**
     * 如果队列为空，返回 true ；否则，返回 false
     * @return
     */
    public boolean empty() {
    	return inStack.isEmpty() && outStack.isEmpty();
    }
    
    private void checkOutStack() {
    	if (outStack.isEmpty()) {
    		while (!inStack.isEmpty()) {
    			outStack.push(inStack.pop());
    		}
		}
	}
}
/**
 * Your MyQueue object will be instantiated and called as such:
 * let obj = MyQueue()
 * obj.push(x)
 * let ret_2: Int = obj.pop()
 * let ret_3: Int = obj.peek()
 * let ret_4: Bool = obj.empty()
 */