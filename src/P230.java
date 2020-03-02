import dto.TreeNode;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * p230 Kth Smallest Element in a BSTv
 * 从二叉搜索树里找第k小的数字
 * 我理解这道题不就是个中序遍历吗，这有啥的，On解决了
 */
public class P230 {

  public static void main(String[] args) {
    P230 p230 = new P230();
    TreeNode treeNode5 = new TreeNode(5);
    TreeNode treeNode3 = new TreeNode(3);
    TreeNode treeNode6 = new TreeNode(6);
    treeNode5.left = treeNode3;
    treeNode5.right = treeNode6;

    TreeNode treeNode2 = new TreeNode(2);
    TreeNode treeNode4 = new TreeNode(4);
    treeNode3.left = treeNode2;
    treeNode3.right = treeNode4;

    TreeNode treeNode1 = new TreeNode(1);
    treeNode2.left = treeNode1;

//    p230.middle(treeNode5);
    System.out.print(p230.kthSmallest(treeNode5, 3));
  }


  // 根据中序遍历-非递归写法 栈(左中右)，改进适配此题目
  public int kthSmallest(TreeNode root, int k) {
    int i = 0;

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.empty()) {
      TreeNode top = stack.peek();
      if(null != top.left) {
        stack.push(top.left);
        top.left = null;
        continue;
      }

      top = stack.pop();
//      System.out.print(top.val);
      i++;
      if(i == k) return top.val;

      if(null != top.right) {
        stack.push(top.right);
      }
    }

    return i;
  }



  // 中序遍历-非递归写法 栈(左中右)
  private void middleFD(TreeNode root) {

    if(null == root) {
      return;
    }

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.empty()) {
      TreeNode top = stack.peek();
      if(null != top.left) {
        stack.push(top.left);
        top.left = null;
        continue;
      }

      top = stack.pop();
      System.out.print(top.val);
      if(null != top.right) {
        stack.push(top.right);
      }
    }

  }


  // 中序遍历-递归写法
  private void middleD(TreeNode root) {
    if(null == root) {
      return;
    }

    if(null != root.left) {
      middleD(root.left);
    }

    System.out.print(root.val);

    if(null != root.right) {
      middleD(root.right);
    }
  }
}
