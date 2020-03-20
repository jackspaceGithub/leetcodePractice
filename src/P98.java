import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * p98 判断有效的二叉搜索树
 */
public class P98 {

  public static void main(String args[]) {
    P98 p98 = new P98();
    p98.test();
  }

  public void test() {
    P98 p98 = new P98();
    P98.TreeNode root = new P98.TreeNode(2);
    root.left = new P98.TreeNode(1);
    root.right = new P98.TreeNode(3);

    System.out.println(p98.isValidBST(root) ? "true" : "false");
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }


  // 中序遍历 先寻找有左子树的节点
  public boolean isValidBST(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    Integer pre = null;
    if(root != null) {
      stack.push(root);
    } else {
      return true;
    }

    while(!stack.empty()) {
      if(stack.peek().left == null) {
        if(pre != null && pre >= stack.peek().val) {
          return false;
        }
        TreeNode top = stack.peek();
        pre = top.val;
        stack.pop();
        if(top.right != null) {
          stack.push(top.right);
        }
      } else {
        TreeNode top = stack.peek();
        stack.push(top.left);
        top.left = null;
      }
    }
    return true;
  }

}
