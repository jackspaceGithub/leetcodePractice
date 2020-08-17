package testConcurrent;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapTest {

  public static void main(String args[]) {
    HashMap map = new HashMap();
    map.put("", "");

    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
    concurrentHashMap.put("", "");
  }
}
