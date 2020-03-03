package p692;

import java.util.*;

/**
 * p692. Top K Frequent Words
 * 前k个高频词
 */
public class P692 {

  public static void main(String args[]) {
    P692 p692 = new P692();
    String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
    int k = 4;
    List<String> list = p692.topKFrequent(words, k);
    for(int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
  }


  /**
   *  先按照笨方法写一次顺便学习一下jdk里面的排序算法是什么
   *  最后也a了，但是这种算法面试肯定不会让我过的，此题目要求最好时间复杂度n*log(k)，空间复杂度额外O(n)，面试的当然不会放过你的
   *
   *  这里复习一下内容：
   *  1，TreeMap是红黑树，红黑树就是非严格均衡的二叉搜索树
   *  https://www.cnblogs.com/LiaHon/p/11203229.html
   *  红黑树的操作时间跟二叉查找树的时间复杂度是一样的，执行查找、插入、删除等操作的时间复杂度为O（logn）。
   *  红黑树是特殊的AVL树，遵循红定理和黑定理 红定理：不能有两个相连的红节点 黑定理：根节点必须是黑节点，而且所有节点通向NULL的路径上，所经过的黑节点的个数必须相等
   *
   *  2，Collection.sort()
   *  2.1 Collection.sort（）排序通过泛型实现对所有类型的排序，对于基础类型，int等，按照数字大小排序，对于自定义对象类型，通过实现Comperable接口，重写compareto函数自定义比较大小的方式。接收对象类型为Comparable子类挥着Comparator外部比较器
   *  2.2 Collections.sort()内部调用的Arrays.sort()方法，对于Arrays类，有两个sort()方法，sort(Object) (归并排序) sort(int) (快排)
   *
   */
  public List<String> topKFrequentStupid(String[] words, int k) {
    TreeMap<String, Integer> treeMap = new TreeMap<>();
    for(int i = 0; i < words.length; i++) {
      if(treeMap.containsKey(words[i])) {
        treeMap.put(words[i], treeMap.get(words[i]) + 1);
      } else {
        treeMap.put(words[i], 1);
      }
    }

    List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(treeMap.entrySet());
    Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
      //降序排序
      public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        return o2.getValue().compareTo(o1.getValue());
      }
    });

    List<String> resultList = new ArrayList<>();
    for(int i = 0; i < k; i++) {
      resultList.add(list.get(i).getKey());
    }
    return resultList;
  }


  /**
   * 走正题，此题需要使用优先队列解决
   * 优先队列：普通队列的意思是先进先出，删除也是先删除队列首部，而优先队列是把队内元素设置了优先级，先删除的是优先级高的元素
   * 实现原理：堆
   * 最常见的堆是二叉搜索树，无脑左右左右即可，要实现优先队列，则需要大根堆（最大堆）和小根堆（最小堆）
   * 以最小堆为例子，它的左右两个节点都要把它大，而且左右两子树又是一个最小堆
   * https://mp.weixin.qq.com/s/NJmGs5rLkxiKfYsipx5jCQ
   * 优先队列维护方法：
   * 1插入：从尾部插入后上浮
   * 2删除：只能删除顶部，然后用尾部替换顶部后进行下沉（下沉的方位是左右孩子里最小的那个）
   * 3构建最小堆：一个完全二叉树，本质上就是让所有非叶子节点依次下沉，从最后一个非叶子节点开始
   *
   * 注意最小堆是用数组存贮的（基于完全二叉树的特性）
   * parent -> left:2*parent + 1    right:2*parent + 2
   *
   * 下面代码抄自leetCode答案， 题目是要最大的几个词，那么就用最小堆解，一直维护一个大小为k的最小堆，超过k时，删除堆顶元素（最小元素），保证元素遍历完后剩下堆中的元素是前k大的词
   */
  public List<String> topKFrequentLeetCode(String[] words, int k) {
    HashMap<String, Integer> map = new HashMap<>();
    for(String s : words) {
      map.put(s, map.getOrDefault(s, 0) + 1);
    }

    // 声明优先队列并定义好优先级规则
    // map.get(w1) - map.get(w2) 表示按照频次进行升序排序，从小到大
    // w2.compareTo(w1) 表示进行字典排序，顺序是从字典序降序排序，从大到小
    PriorityQueue<String> priorityQueue = new PriorityQueue<>(
            (w1, w2) -> map.get(w1).equals(map.get(w2)) ?
                    w2.compareTo(w1) : map.get(w1) - map.get(w2)
    );

    for (String word: map.keySet()) {
      // 插入元素
      priorityQueue.offer(word);
      // 超过k了，则堆顶元素是第k+1大的词，没意义，删除掉，我们只需要得到一个k大小的堆即可
      if (priorityQueue.size() > k) priorityQueue.poll();
    }

    List<String> ans = new ArrayList();
    // 依次取出堆顶元素
    while (!priorityQueue.isEmpty()) ans.add(priorityQueue.poll());
    // 翻转
    Collections.reverse(ans);
    return ans;
  }

  /**
   * 自己实现一遍，正序实现
   * @param words
   * @param k
   * @return
   */
  public List<String> topKFrequent(String[] words, int k) {
    HashMap<String, Integer> map = new HashMap<>();
    for(String s : words) {
      map.put(s, map.getOrDefault(s, 0) + 1);
    }

    PriorityQueue<String> queue = new PriorityQueue<String>(
            (w1, w2) -> {
              return map.get(w1).equals(map.get(w2)) ? w1.compareTo(w2) : map.get(w2) - map.get(w1);
            }
    );

    queue.addAll(map.keySet());
    List<String> results = new ArrayList<>();
    for(int i = 0; i < k; i++) {
      results.add(queue.poll());
    }
    return results;
  }

}
