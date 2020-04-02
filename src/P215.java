import java.util.PriorityQueue;

/**
 * p215 Kth Largest Element in an Array
 * 找数组中第k大的数字
 * 建立最小堆，维护堆大小为k，取堆顶
 * 时间复杂度n*logn
 * 空间复杂度n
 *
 * 最小堆的维护方法：
 * 插入元素： 在堆尾插入，然后进行“上浮”
 * 删除堆顶： 将堆顶元素和堆尾部元素进行交换，然后删除尾部元素，堆顶元素进行 “下沉”操作
 */
public class P215 {

  public static void main(String args[]) {
    P215 p215 = new P215();
    p215.test();
  }

  public void test() {
    int[] nums = new int[]{3,2,1,5,6,4};
    int k = 2;
    System.out.println(findKthLargest(nums, k));
  }

  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
      (w1, w2) -> w1 - w2
    );

    for(int i = 0; i < nums.length; i++) {
      priorityQueue.add(nums[i]);
      if(priorityQueue.size() > k){
        priorityQueue.poll();
      }
    }

    return priorityQueue.peek();
  }

}
