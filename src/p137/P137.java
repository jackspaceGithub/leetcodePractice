package p137;

/**
 * p127
 * 这道位运算解法真是无话可说，我脑子不够用
 */
public class P137 {

  public int singleNumber(int[] nums) {
    int a = 0;
    int b = 0;
    for(int i = 0; i < nums.length; i++) {
      a = (a ^ nums[i]) & ~b;
      b = (b ^ nums[i]) & ~a;
    }
    return a;
  }
}
