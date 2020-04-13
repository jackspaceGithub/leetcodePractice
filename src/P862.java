import java.util.Deque;
import java.util.LinkedList;

/**
 * p862 Shortest Subarray with Sum at Least K
 *
 * 前缀和 + 单调栈
 */
public class P862 {

  public static void main(String args[]) {
    P862 p = new P862();
    p.test();
  }

  public void test() {
    int[] A = new int[]{2,-1,2};
    int k = 3;
    System.out.println(shortestSubarray(A, k));
  }

  /**
   * 1.前缀和：子数组相关求解，肯定是用前缀和。
   * 2.单调栈
   * 由于该题存在负数，因此前缀和不是递增序列
   * 但是由于单调递增序列如果大于等于K，则非单调的序列的数组和一定小于单调递增序列，而且非单调序列长度更大。举例说明
   * 序列：1,4,-2,4
   * 前缀和：1,5,3,7
   * 单调栈是 1 3 7 ，7与3的差值一定大于7与5的差值，并且7与3的数组长度要小于7与5的，因此序列5可以被舍弃
   * 现在有了前缀和序列就可以完全不用看原序列了，问题转化为对从前缀和序列求距离最近且满足差值>=K的距离
   * 所以我们要维护一个单调栈，如果新进来的数字比栈顶元素小，则破坏了单调属性，栈顶元素出栈，继续比较直到新元素小于栈顶元素，这样就维护了单调栈
   * 加入前缀和序列为 2,4,8 新进来个1，那么再后面的元素与1相减肯定小于和栈顶8差值，而且距离一定小于和8的距离，所以8已经没有存在的意义
   *
   * @param A
   * @param K
   * @return
   */
  public int shortestSubarray(int[] A, int K) {
    int min = Integer.MAX_VALUE;
    // 做单调栈，记得栈内存的是下标不是数值
    Deque<Integer> deque = new LinkedList<>();
    // 做前缀和
    int[] preSum = new int[A.length];
    for(int i = 0; i < A.length; i++) {
      if(i == 0) {
        preSum[i] = A[i];
      } else {
        preSum[i] += A[i] + preSum[i - 1];
      }
    }

    // 到此就跟A没关系了，就用前缀和数组preSum即可
    for(int i = 0; i < preSum.length; i++) {

      // 注意这种从0~i的区间也要考虑
      if(preSum[i] >=K) {
        min = Integer.min(min, i + 1);
      }

      // 首先维护单调性，取栈顶（队尾）元素比较大小
      while(!deque.isEmpty() && preSum[deque.getLast()] >= preSum[i]) {
        deque.removeLast();
      }

      // 维护完单调性，可以开始寻找满足差值>=K的最短区间了
      // 取栈底（队首）元素跟前缀和当期数组做 preSum[i] 差，如果连栈底元素都满足了条件，那么则记录好后就将栈底元素移除，因为后面再新进来元素preSum[i+1]的时候，
      // 离这个栈顶元素的距离肯定要大于跟 preSum[i] 的距离，所以即使满足>=K的条件也没意义，只能去跟没有满足preSum[i]差值>=K的元素比较
      while(!deque.isEmpty() && preSum[i] - preSum[deque.getFirst()] >= K) {
        min = Integer.min(min, i - deque.getFirst());
        deque.removeFirst();
      }

      deque.addLast(i);
    }

    return min == Integer.MAX_VALUE ? -1 : min;
  }
}
