import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * p236 Lowest Common Ancestor of a Binary Tree
 * 二叉树两节点的最低公共祖先
 */
public class P236 {

  public static void main(String args[]) {
    P236 p = new P236();
    p.test();
  }

  public void test() {
    List<Integer> list = new ArrayList<Integer>(Arrays.asList(3,5,1,6,2,0,8,null,null,7,4));
    TreeNode[] treeNodeList = convertListToTree(list);
    TreeNode result = lowestCommonAncestor(treeNodeList[0], treeNodeList[1], treeNodeList[10]);
    System.out.println(result.val);
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public TreeNode[] convertListToTree(List<Integer> list) {
    TreeNode[] treeNodeList = new TreeNode[list.size()];
    int i2 = 0;
    for(Integer val : list) {
      treeNodeList[i2++] = val != null ? new TreeNode(val) : null;
    }

    for(int i = 0; i < treeNodeList.length; i++) {
      if(null != treeNodeList[i]) {
        treeNodeList[i].left = (2*i + 1) >= treeNodeList.length ? null : treeNodeList[2*i + 1];
      }
      if(null != treeNodeList[i]) {
        treeNodeList[i].right = (2*i + 2) >= treeNodeList.length ? null : treeNodeList[2*i + 2];
      }
    }
    return treeNodeList;
  }


  TreeNode node = null;
  // 递归搜索
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    search(root, p, q);
    return node;
  }

  private boolean search(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null) return false;

    boolean left = search(root.left, p ,q);
    boolean right = search(root.right, p ,q);
    boolean mid = (root.val == p.val || root.val == q.val);
    if((mid && left) || (mid && right) || (left && right)) {
      node = root;
    }
    return left || right || mid;
  }

}
