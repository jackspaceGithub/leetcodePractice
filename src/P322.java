import java.util.*;

/**
 * 考虑到有 [1,7,10] 这种用例，按照贪心思路 10 + 1 + 1 + 1 + 1 会比 7 + 7 更早找到
 */
public class P322 {

  public static void main(String args[]) {
    P322 p = new P322();
    System.out.println(p.coinChange(new int[]{186,419,83,408}, 6249));
  }

  public int coinChange(int[] coins, int amount) {
    List<Integer> list = new ArrayList<Integer>();
    for(int e : coins) {
      list.add(e);
    }
    list.sort(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
      }
    });
    int[] coins2 = new int[coins.length];
    int i = 0;
    for(Integer e : list) {
      coins2[i++] = e;
    }

    int min = Integer.MAX_VALUE;
    for(int i2 = coins.length - 1; i2 >= 0; i2--) {
      int result = count(coins2, i2, amount);
      if(result == - 1) {
        continue;
      }
      min = Math.min(result, min);
    }
    return min == Integer.MAX_VALUE ? -1 : min;
  }

  private int count(int[] coins, int end, int amount) {
    if(end < 0) return -1;
    if(amount == 0) return 0;
    int mod = amount/coins[end];
    int min = Integer.MAX_VALUE;
    for(int i = mod; i >= 1; i--) {
      int yushu = amount - i * coins[end];
      if(yushu == 0) {
        return mod;
      }
      // 把余数向下分发，如果余数分发失败则，商-1再重复上述步骤
      int yushuCount = count(coins, end - 1, yushu);
      if(yushuCount == -1) {
        continue;
      } else {
        min = Math.min(mod + yushuCount, min);
      }
    }
    return min == Integer.MAX_VALUE ? -1 : min;
  }
}
