import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * p946. Validate Stack Sequences
 * 判断是否是有效的栈顺序
 */
public class P946 {

  public static void main(String args[]) {
    P946 p946 = new P946();
    p946.test();
  }

  public void test() {
    int[] pushed = new int[]{1,2,3,4,5};
    int[] popped = new int[]{4,5,3,2,1};
    System.out.println(validateStackSequences(pushed, popped) ? "true" : "false");
  }

  /**
   * 我的想法是模拟
   * pop数组的第一个元素x，拿着x在push数组里找，则x和其前面的数字一定是事先都被push进去了，这个是确定的。
   * 以x为分界点，push数组后面的数列独立成 push_after 数组，前面的就是 push_before
   * 开始正序遍历pop数组，倒序遍历 push_before 数组，pop[0] == push_before[push_before.length - 1] 则 正确，push_before下标-1
   * pop下标+1，如果 pop[i] != push_before[x] ， 则 从 push_after 取一个元素加入进来，再重复以上
   */
  public boolean validateStackSequences(int[] pushed, int[] popped) {

    Stack<Integer> pushBeforeStack = new Stack<>();
    Queue<Integer> pushAfterQueue = new LinkedList<>();

    boolean gan = false;
    for (int value : pushed) {
      if (!gan) {
        if (value == popped[0]) {
          gan = true;
        }
        pushBeforeStack.push(value);
      } else {
        pushAfterQueue.add(value);
      }
    }

    // 记录pop数组下标
    int popI = 0;
    while(popI < popped.length) {
      if (!pushBeforeStack.empty() && pushBeforeStack.peek() == popped[popI]) {
        popI++;
        pushBeforeStack.pop();
        if(pushBeforeStack.empty() && !pushAfterQueue.isEmpty()) {
          pushBeforeStack.push(pushAfterQueue.poll());
        }
      } else if(!pushAfterQueue.isEmpty()) {
        pushBeforeStack.push(pushAfterQueue.poll());
      } else {
        return false;
      }
    }

    return true;
  }
}
