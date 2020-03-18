/**
 * p53 Maximum Subarray
 *
 */
public class P53 {

  public static void main(String args[]) {
    P53 p53 = new P53();
    System.out.println(p53.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
  }



  public int maxSubArray(int[] nums) {
    int sum = nums[0];
    int max = nums[0];
    for(int i=1; i < nums.length; i++) {
      if(sum <= 0) {
        sum = nums[i];
      } else {
        sum += nums[i];
      }

      if(sum > max) max = sum;
    }
    return max;
  }

}
