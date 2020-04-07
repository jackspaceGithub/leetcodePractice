/**
 * p415 Add Strings
 * 大数加法
 */
public class P415 {

  public static void main(String args[]){
    P415 p415 = new P415();
    p415.test();
  }

  public void test() {
    System.out.println(addStrings("99", "1"));
  }

  public String addStrings(String num1, String num2) {
    char[] num1List = num1.toCharArray();
    char[] num2List = num2.toCharArray();
    int minLength = Math.min(num1.length(), num2.length());

    int jinwei = 0;
    String result = "";
    for(int i = 1; i <= minLength; i++) {
      int index1 = num1.length() - i;
      int index2 = num2.length() - i;

      int sum = ((num1List[index1] - '0') + (num2List[index2] - '0')) + jinwei;
      int nowPlace = sum % 10;
      jinwei = sum/10;
      result = nowPlace + result;
    }

    if(minLength == num1.length()) {
      for(int i = num2.length() - minLength - 1; i >= 0; i--) {
        int sum = (num2List[i] - '0') + jinwei;
        int nowPlace = sum % 10;
        jinwei = sum/10;
        result = nowPlace + result;
      }
    } else {
      for(int i = num1.length() - minLength - 1; i >= 0; i--) {
        int sum = (num1List[i] - '0') + jinwei;
        int nowPlace = sum % 10;
        jinwei = sum/10;
        result = nowPlace + result;
      }
    }

    return jinwei == 0 ? result : (jinwei + result);
  }
}
