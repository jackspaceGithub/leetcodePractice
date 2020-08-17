package test2;

import sun.nio.ch.DirectBuffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class ListTest {

  public static void main(String args[]) {
    List<HashMap<Integer, Integer>> list1 = new ArrayList<>();
    HashMap<Integer, Integer> hashMap1 = new HashMap<>();
    hashMap1.put(0, 0);
    hashMap1.put(1, 10);
    list1.add(hashMap1);
    HashMap<Integer, Integer> hashMap2 = new HashMap<>();
    hashMap2.put(0, 11);
    hashMap2.put(1, null);
    list1.add(hashMap2);

    int diffOfDays = 10;
    Optional<HashMap<Integer, Integer>> configOptional = list1.stream()
            .filter(e -> e.get(0) <= diffOfDays && (e.get(1) == null || e.get(1) >= diffOfDays)).findFirst();
    HashMap<Integer, Integer> result  = configOptional.orElse(null);
    System.out.println(result.get(0));
    System.out.println(result.get(1));
  }

}
