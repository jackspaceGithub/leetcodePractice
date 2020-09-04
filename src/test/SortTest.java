package test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortTest {

  public static void main(String args[]) {
    S s = new S();
    s.setList(new ArrayList<>());
    s.getList().add(8);
    s.getList().add(1);
    s.getList().add(5);
    s.getList().add(2);
    s.getList().add(4);
    s.getList().sort(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1 - o2;
      }
    });

    System.out.println(s.getList());
  }

}
