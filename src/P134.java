/**
 * p134 Gas Station
 * 思路：错位相减转换为净消耗数组
 * 全部相加后大于等于0则说明一定是有解的
 * 最后的问题就是找到起始点，起始点必须具备的条件是，从它开始往后相加不能出现负数，否则就不是起始点
 * 如果判断他有解，说明整个区间是一个大于等于0的区间
 * 因为题目中说只有唯一解，那么，大区间里肯定有负数区间，如果没有负数区间肯定不是唯一解
 * 下面的我也证明不出来了，看leetcode才知道用反证法证明
 *
 * 还是另一种说法更清晰，画图，xy轴
 */
public class P134 {

  public static void main(String args[]) {
    P134 p134 = new P134();
    p134.test();
  }

  public void test() {
    int[] gas = {1,2,3,4,5};
    int[] cost = {3,4,5,1,2};
    System.out.println(canCompleteCircuit(gas, cost));
  }


  public int canCompleteCircuit(int[] gas, int[] cost) {
    int n = gas.length;
    int currentAmount = 0;
    int totalAmount = 0;
    int startIndex = 0;
    for(int i = 0; i < n; i++) {
      currentAmount += gas[i] - cost[i];
      totalAmount += gas[i] - cost[i];
      if(currentAmount < 0) {
        currentAmount = 0;
        startIndex = i + 1;
      }
    }
    return totalAmount < 0 ? -1 : startIndex;
  }
}
