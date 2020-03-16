import java.util.*;

/**
 * p15 3SUM
 * 排序后能巧妙的去重
 *
 * 标签：数组遍历
 * 首先对数组进行排序，排序后固定一个数 nums[i]nums[i]，再使用左右指针指向 nums[i]nums[i]后面的两端，数字分别为 nums[L]nums[L] 和 nums[R]nums[R]，计算三个数的和 sumsum 判断是否满足为 00，满足则添加进结果集
 * 如果 nums[i]nums[i]大于 00，则三数之和必然无法等于 00，结束循环
 * 如果 nums[i]nums[i] == nums[i-1]nums[i−1]，则说明该数字重复，会导致结果重复，所以应该跳过
 * 当 sumsum == 00 时，nums[L]nums[L] == nums[L+1]nums[L+1] 则会导致结果重复，应该跳过，L++L++
 * 当 sumsum == 00 时，nums[R]nums[R] == nums[R-1]nums[R−1] 则会导致结果重复，应该跳过，R--R−−
 * 时间复杂度：O(n^2)O(n
 * 2
 *  )，nn 为数组长度
 *
 * 作者：guanpengchn
 * 链接：https://leetcode-cn.com/problems/3sum/solution/hua-jie-suan-fa-15-san-shu-zhi-he-by-guanpengchn/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class P15 {

  public static void main(String[] args) {
    P15 p15 = new P15();
    int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
    List<List<Integer>> results = p15.threeSum(nums);
    System.out.println();
  }


  public List<List<Integer>> threeSum(int[] nums) {

    List<List<Integer>> results = new ArrayList<>();
    List<Integer> numList = new ArrayList<>();
    for(int i = 0; i < nums.length; i++) {
      numList.add(nums[i]);
    }
    numList.sort(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1 - o2;
      }
    });

    for(int i = 0; i < nums.length; i++) {
      if(numList.get(i) > 0) break;
      if(i > 0 && numList.get(i).equals(numList.get(i - 1))) continue;
      int left = i + 1;
      int right = nums.length - 1;

      while(left < right) {

        if(left > i + 1 && numList.get(left).equals(numList.get(left - 1))) {
          left++;
          continue;
        }

        if(right < nums.length - 1 && numList.get(right).equals(numList.get(right + 1))) {
          right--;
          continue;
        }

        int sum = numList.get(left) + numList.get(i) + numList.get(right);
        if(sum == 0) {
          List<Integer> tmp = new ArrayList<>();
          tmp.add(numList.get(i));
          tmp.add(numList.get(left));
          tmp.add(numList.get(right));
          results.add(tmp);
          left++;
          right--;
          continue;
        }

        if(sum > 0) {
          right--;
          continue;
        }

        left++;
      }
    }
    return results;
  }


}
