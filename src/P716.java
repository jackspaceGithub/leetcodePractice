import java.util.Stack;

/**
 * p716 Max Stack 最大栈
 *
 * 两个栈实现最大栈，要求 pop，push，get_max 都为O(1)
 * https://www.cnblogs.com/liuliu5151/p/9828162.html
 */
public class P716 {

  // maintain stack to track all the data
  Stack<Integer> stack  =  new Stack<Integer>();
  // maintain maxStack to update current max
  Stack <Integer> maxStack  =  new Stack<Integer>();

  public void push(int x) {
    // 保证stack和maxStack的元素数量一致， 即便 x == maxStack.peek(), 也会同时push到maxStack和stack
    if (maxStack.isEmpty() || x >= maxStack.peek()){
      maxStack.push(x);
    }
    stack.push(x);
  }

  public int pop() {
    if (stack.peek().equals(maxStack.peek())){
      maxStack.pop();
    }
    return stack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int peekMax() {
    return maxStack.peek();
  }

  public int popMax() {
    // maintain a tempStack to help convert data
    Stack <Integer> tempStack  =  new Stack<Integer>();

    int max  = maxStack.peek();
    // 1. push non-max item into tempStack
    while (!stack.peek().equals(maxStack.peek())){
      tempStack.push(stack.pop());
    }
    stack.pop();
    maxStack.pop();

    //2. directly use push() we wrote, pushing items back in both stack and tempStack
    while(!tempStack.isEmpty()){
      push(tempStack.pop());
    }
    return max;
  }
}
