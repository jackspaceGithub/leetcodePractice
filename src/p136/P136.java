package p136;

/**
 * p136 Single Number
 * 简单题，但是怎么样能在不开辟额外内存的情况下完成呢
 * 答案是位运算
 */
public class P136 {

  public int singleNumber(int[] nums) {
    int result = 0;
    for(int i = 0; i < nums.length; i++) {
      result = result ^ nums[i];
    }
    return result;
  }
}
