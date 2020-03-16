import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/**
 * p1 Two Sum
 */
public class P1 {

  public static void main(String[] args) {
    P1 p1 = new P1();
    int[] nums = new int[]{2, 7, 11, 15};
    int[] results = p1.twoSum(nums, 9);
    for(int i = 0; i < results.length; i++) {
      System.out.print(results[i] + " ");
    }
    System.out.println();
  }

  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < nums.length; i++) {
      if(map.containsKey(target - nums[i])) {
        return new int[]{map.get(target - nums[i]), i};
      }
      map.put(nums[i], i);
    }
    return null;
  }
}
