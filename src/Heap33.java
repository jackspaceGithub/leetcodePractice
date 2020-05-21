import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 我决定手写一个最小堆
 * 堆顶元素比子节点都小
 * 因为最小堆是一个完全二叉树，所以它是可以用数组去实现的，所以找堆尾元素就很简单了
 *
 * 如果用数组实现要知道子节点公式
 * 【父节点下标】 * 2 + 1 = 【左子节点下标】
 * 【父节点下标】 * 2 + 2 = 【右子节点下标】
 *
 * 所以 【父节点下标】 = 【子节点下标】 == 偶数 ? (【子节点下标】 - 2 )/2  :  (【子节点下标】 - 1 )/2
 *
 * 用数组效率高，就是浪费空间
 *
 * 最小堆的维护方法：
 * 插入元素： 在堆尾插入，然后进行“上浮”
 * 删除堆顶： 将堆顶元素和堆尾部元素进行交换，然后删除尾部元素，堆顶元素进行 “下沉”操作
 * 查询方法不用说了
 */
public class Heap33 {

  public static void main(String args[]) {
    Heap33 heap33 = new Heap33();
    heap33.test();
  }

  public void test() {
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(3);
    List<Integer> list2 = list.stream()
            .filter(e -> e > 2)
            .collect(Collectors.toList());
    System.out.print(list2);
    System.out.print("");
  }
}
