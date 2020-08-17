/**
 * 找二叉树里两个节点的最近父节点
 */
public class FindClosedParentNode {

  /**
   * 方法一：
   * 如果二叉树又回溯指针，即指向父节点的指针，那么我们可以先按层遍历树，找到两个节点的层数，
   * 假设两个节点是x和y，y节点层数深
   * 将y回溯到跟x一样的层数，比较x和y此时是否是同一个节点，如果是则父类就是x，
   * 如果不是同一个，则两点一起向上回溯直到指向同一个点为止
   *
   * 时间负责度，遍历树 O(n)
   * 回溯 2*log(n)
   * 总体 = O(n) + 2*log(n)
   */


  /**
   * 方法二：
   * 如果没有回溯指针的情况下该怎么做呢？
   * 深搜即可，
   * 左子树有一个目标节点并且右子树也有目标节点，则这个父节点就找到了。
   * 或者当前节点本身就是父节点，则左右子树找到一个就可以
   *
   * 递归问题思考起来很头疼，代码不知道怎么写，这里个人总结一个技巧就是，我们可以先假设已经递归到了最底层的叶子节点，从这里开始思考，逐层往上处理
   */

  class Node {
    Node left;
    Node right;
  }

  Node result;

  public Node getPublicNode(Node head, Node node1, Node node2) {
    search(head, node1, node2);
    return result;
  }

  private boolean search(Node head, Node node1, Node node2) {

    if(head == null) {
      return false;
    }

    boolean leftResult = search(head.left, node1, node2);
    boolean rightResult = search(head.right, node1, node2);
    boolean currentResult = head == node1 || head == node2;
    // 找到俩个分支都有，那就是找到了
    if((leftResult && rightResult)
    || currentResult && (leftResult || rightResult)) {
      result = head;
      return true;
    }
    // 如果不是左右分支都有的，返回是否找到了即可
    return currentResult || leftResult || rightResult;
  }
}
