import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 496. Next Greater Element I
 * 寻找下一个更大的数，怎么用O(n)实现
 * 题意理解完全错误，它的意思是找到数组中数值为x的数，这个x在数组2中的位置是n，那么n以后有没有比他大的数字
 * 单调栈
 * 单调栈是个很神奇的数据结构，它能维护栈的顺序保持单调递增或者递减
 */
public class P496 {

  public static void main(String args[]) {
    P496 p496 = new P496();
    p496.test();
  }

  public void test() {
    int[] result = nextGreaterElement(new int[]{2,4}, new int[]{1,2,3,4});
    for(int i = 0; i < result.length; i++) {
      System.out.print(result[i] + " ");
    }
    System.out.println();
  }

  // 虽然是两层for循环但是 nums2的
//  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//    int[] result = new int[nums1.length];
//    Arrays.fill(result, -1);
//
//    for(int i2 = 0; i2 < nums2.length; i2++) {
//      for(int i1 = 0; i1 < Math.min(nums1.length, nums2.length - i2) && result[i1] == -1; i1++) {
//        if(nums2[i2 + i1] > nums1[i1]) {
//          result[i1] = nums2[i2 + i1];
//        }
//      }
//    }
//    return result;
//  }

  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    Stack<Integer> stack = new Stack<>();
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    for(int i = 0; i < nums2.length; i++) {
      while(!stack.empty() && stack.peek() < nums2[i]) {
        hashMap.put(stack.peek(), nums2[i]);
        stack.pop();
      }
      stack.push(nums2[i]);
    }
    int[] result = new int[nums1.length];
    for(int i = 0; i < nums1.length; i++) {
      result[i] = hashMap.getOrDefault(nums1[i], -1);
    }
    return result;
  }
}
