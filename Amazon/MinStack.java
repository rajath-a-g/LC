package Amazon;

import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;
    private Stack<int[]> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {
        if (minStack.peek()[0] == x) {
            minStack.peek()[1]++;
        } else if (minStack.empty() || minStack.peek()[0] > x) {
            minStack.push(new int[]{x, 1});
        }
        stack.push(x);
    }

    public void pop() {
        minStack.peek()[1]--;
        if (minStack.peek()[1] == 0)
            minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek()[0];
    }
}
