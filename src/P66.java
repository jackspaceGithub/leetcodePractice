import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * p66 Plus One
 */
public class P66 {

  public static void main(String args[]) {
    P66 p66 = new P66();
    int[] results = p66.plusOne(new int[] {4,3,2,1});
    for(int i=0; i < results.length; i++) {
      System.out.print(results[i] + " ");
    }
    System.out.println();
  }

  public int[] plusOne(int[] digits) {
    boolean jinwei = true;
    for(int i = digits.length - 1; i >=0; i--) {
      if(jinwei) {
        digits[i]++;
        if(digits[i] >= 10) {
          digits[i] = digits[i] % 10;
        } else {
          jinwei = false;
        }
      } else {
        break;
      }
    }

    if(jinwei) {
      int[] results = new int[digits.length + 1];
      results[0] = 1;
      int i2 = 1;
      for(int i = 0; i < digits.length - 1; i++) {
        results[i2++] = digits[i];
      }
      return results;
    }

    return digits;
  }
}
