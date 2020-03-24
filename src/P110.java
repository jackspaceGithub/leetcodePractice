/**
 * p110 Balanced Binary Tree
 * 提前截断
 */
public class P110 {


  public static void main(String args[]) {
    P110 p110 = new P110();
    p110.test();
  }

  public void test() {
    TreeNode treeNode = new TreeNode(1);
    TreeNode treeNode1 = new TreeNode(2);
    TreeNode treeNode2 = new TreeNode(2);
    treeNode.left = treeNode1;
    treeNode.right = treeNode2;

    treeNode1.left = new TreeNode(3);
    treeNode1.right = new TreeNode(3);

    treeNode1.left.left = new TreeNode(4);
    treeNode1.left.right = new TreeNode(4);
    System.out.println(isBalanced(treeNode) ? "true" : "false");
    System.out.println(getHeight(treeNode2));
    System.out.println(getHeight(treeNode));
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  /**
   * 自上而下暴力解法
   * @param root
   * @return
   */
//  public boolean isBalanced(TreeNode root) {
//    if(root == null) return true;
//    return Math.abs(getHeight(root.left) - getHeight(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
//  }
//
//  private int getHeight(TreeNode node) {
//    if(node == null) return 0;
//    return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
//  }
  public boolean isBalanced(TreeNode root) {
    if(root == null) return true;
    return getHeight(root) != -1;
  }

  private int getHeight(TreeNode node) {
    if(node == null) return 0;
    int p = getHeight(node.left);
    if(p == -1) {
      return -1;
    }
    int p2 = getHeight(node.right);
    if(p2 == -1) {
      return -1;
    }

    int cha =  Math.abs(p - p2);
    if(cha > 1) {
      return -1;
    } else {
      return Math.max(p, p2) + 1;
    }
  }
}
