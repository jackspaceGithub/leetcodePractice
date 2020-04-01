import java.util.Date;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * p146 LRU
 */
public class P146 {

  class LRUCache {

    private class KV{
      int key;
      int value;

      public int getKey() {
        return key;
      }

      public void setKey(int key) {
        this.key = key;
      }

      public int getValue() {
        return value;
      }

      public void setValue(int value) {
        this.value = value;
      }
    }

    KV[] kvList;
    Integer[] queueList;
    Queue<Integer> queue;
    int capacity;

    public LRUCache(int capacity) {
      this.capacity = capacity;
      queueList = new Integer[capacity + 1];
      queue = new LinkedList<>();
      kvList = new KV[capacity + 1];
    }

    public int get(int key) {
      // 判断元素是否存在
      if(key > capacity || kvList[key] == null) {
        return -1;
      }

      // 如果存在就返回同时要维护优先队列
      queue.remove(queueList[key]);
      Integer keyNew = key;
      queue.add(keyNew);
      return kvList[key].value;
    }

    public void put(int key, int value) {
      if() {

      }
    }
  }

  public void test() {

  }
}
