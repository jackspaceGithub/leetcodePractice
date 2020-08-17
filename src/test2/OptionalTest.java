package test2;

import java.util.HashMap;
import java.util.Optional;
import java.util.TreeMap;

public class OptionalTest {

  public static void main(String args[]) {
    Optional optional = Optional.ofNullable(null);
    optional = Optional.empty();
    Object p = optional.get();
    System.out.println(p);
  }
}
