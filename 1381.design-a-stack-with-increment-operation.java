/*
 * @lc app=leetcode id=1381 lang=java
 *
 * [1381] Design a Stack With Increment Operation
 */

// @lc code=start
import java.util.Stack;

class CustomStack
{
    Stack<Integer> stack;
    int capacity;

    public CustomStack(int maxSize)
    {
        stack = new Stack<>();    
        this.capacity = maxSize; 
    }
    
    public void push(int x)
    {
        if(stack.size() < capacity)
        {
            stack.push(x);
        }
    }
    
    public int pop() 
    {
        if(stack.isEmpty())
        {
            return -1;
        }
        return stack.pop();
    }
    
    public void increment(int k, int val)
    {
        for(int i = 0; i < Math.min(k, stack.size()); i++)
        {
            stack.set(i, stack.get(i) + val);
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
// @lc code=end

