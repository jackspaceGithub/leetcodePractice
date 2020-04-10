/**
 * p860 Lemonade Change
 *
 */
public class P860 {

  public static void main(String args[]) {
    P860 p860 = new P860();
    p860.test();
  }

  public void test() {
    int[] bills = new int[]{5,5,10,10,20};
    System.out.println(lemonadeChange(bills) ? "true" : "false");
  }

  public boolean lemonadeChange(int[] bills) {
    int five = 0;
    int ten = 0;
    int twenty = 0;
    for(int i = 0; i < bills.length; i++) {
      if(bills[i] == 5) {
        five++;
      } else if(bills[i] == 10) {
        ten++;
        if(five > 0) five--;
        else return false;
      } else if(bills[i] == 20) {
        twenty++;
        if(ten > 0 && five > 0){
          ten--;
          five--;
        } else if(five > 2) {
          five -= 3;
        } else {
          return false;
        }
      }
    }

    return true;
  }
}
