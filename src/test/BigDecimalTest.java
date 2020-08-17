package test;

import java.math.BigDecimal;

public class BigDecimalTest {

  public static void main(String args[]) {
    BigDecimal d = new BigDecimal(19);
    BigDecimal p = d;
    p = p.subtract(new BigDecimal(1));
    System.out.println(d);
    System.out.println(p);
  }
}
