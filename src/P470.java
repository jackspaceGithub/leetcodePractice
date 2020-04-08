import java.math.BigDecimal;

/**
 * p470 Implement Rand10() Using Rand7()
 * 用均匀随机数api生成另一个均匀随机数
 */
public class P470 {

  int x;

  public static void main(String args[]){
    P470 p470 = new P470();
    p470.test();
  }

  public void test() {
    for(int i = 1; i <=7; i++){
      x = i;
      System.out.println(rand10());
    }
    for(int i = 1; i <=3; i++){
      x = i;
      System.out.println(rand10());
    }
  }

  public int rand7() {
    return x;
  }



//  我们可以用拒绝采样的方法实现 Rand10()。在拒绝采样中，如果生成的随机数满足要求，那么久返回该随机数，否则会不断生成直到一个满足要求的随机数为止。若我们调用两次 Rand7()，那么可以生成 [1, 49] 之间的随机整数，我们只用到其中的 40 个，用来实现 Rand10()，而拒绝剩下的 9 个数，如下图所示

  public int rand10() {
    int index = rand7() + (rand7() - 1) * 7;
    while (index > 40) {
      index = rand7() + (rand7() - 1) * 7;
    }
    return 1 + (index - 1) % 10;
  }

}
