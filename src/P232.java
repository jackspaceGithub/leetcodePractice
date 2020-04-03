import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * p232 Implement Queue using Stacks
 *
 */
public class P232 {

  public void test() {
     MyQueue obj = new MyQueue();
     obj.push(1);
     int param_2 = obj.pop();
     int param_3 = obj.peek();
     boolean param_4 = obj.empty();
  }

  class MyQueue {

    Deque<Integer> deque;

    /** Initialize your data structure here. */
    public MyQueue() {
      deque = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
      deque.addLast(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
      return deque.removeFirst();
    }

    /** Get the front element. */
    public int peek() {
      return deque.getFirst();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
      return deque.isEmpty();
    }
  }
}
