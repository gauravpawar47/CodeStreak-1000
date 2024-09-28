/*
 * @lc app=leetcode id=641 lang=java
 *
 * [641] Design Circular Deque
 */

// @lc code=start
import java.util.Deque;
import java.util.LinkedList;

class MyCircularDeque
{
    int capacity;
    Deque<Integer> dq;

    public MyCircularDeque(int k)
    {
        this.capacity = k;
        this.dq = new LinkedList<>();
    }
    
    public boolean insertFront(int value)
    {
        if(isFull())
        {
            return false;
        }

        dq.addFirst(value);
        return true;
    }
    
    public boolean insertLast(int value)
    {
        if(isFull())
        {
            return false;
        }

        dq.addLast(value);
        return true;
    }
    
    public boolean deleteFront()
    {
        if(isEmpty())
        {
            return false;
        }

        dq.removeFirst();
        return true;
        
    }
    
    public boolean deleteLast()
    {
        if(isEmpty())
        {
            return false;
        }

        dq.removeLast();
        return true;
    }
    
    public int getFront()
    {
        if(isEmpty())
        {
            return -1;
        }
        
        return dq.getFirst();
    }
    
    public int getRear()
    {
        if(isEmpty())
        {
            return -1;
        }
        
        return dq.getLast();
    }
    
    public boolean isEmpty()
    {
        return dq.isEmpty();
    }
    
    public boolean isFull()
    {
        return dq.size() == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
// @lc code=end

