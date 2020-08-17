package test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

  public static void main(String args[]) {
    List<StreamMem> list = new ArrayList<>();
    list.add(new StreamMem(1));
    list.add(new StreamMem(2));
    list.add(new StreamMem(3));

    List<StreamMem> list2 = list.stream().filter(e -> e.getSs() > 2).collect(Collectors.toList());
    list2.get(0).setSs(88);
    System.out.println(list.get(2).getSs());
  }
}
