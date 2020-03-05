package p212;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * p212 Word Search II
 * 单词查找2
 */
public class P212Failure {

  public static void main(String args[]) {
//    char[][] board = {
//            {'o','a','a','n'},
//            {'e','t','a','e'},
//            {'i','h','k','r'},
//            {'i','f','l','v'}
//    };
//    String[] words = {"oath","pea","eat","rain"};
    String[] words = {"aaa"};
    char[][] board = {
            {'a', 'a'}
    };

    Set<Character> set = new HashSet();
    for(int i = 0; i < board.length; i++) {
      for(int i2 = 0; i2 < board[0].length; i2++) {
        set.add(board[i][i2]);
      }
    }

    for(Character c : set) {
      System.out.print(c.charValue());
    }
    System.out.println();


    P212Failure p212Failure = new P212Failure();
    List<String> list = p212Failure.findWords(board, words);
    list.forEach(e -> System.out.println(e));
  }

  /**
   * 这道题自己的想法是进行深度优先搜索建立前缀树，但是中间有很多阻碍
   * 1, 如果无脑挨个点去dfs，那么时间复杂度非常高，n是矩阵里点的个数的话，则大约是 n * dfs复杂度
   * 2, 空间复杂度高，这应该算一个有向图，还要考虑回溯路径，要生成多少棵树啊
   * 先做吧，不行再说
   */
  public List<String> findWords(char[][] board, String[] words) {

    // 建树
    Node head = new Node();
    head.nextNodes = new Node[26];
    for(int iBordOut = 0; iBordOut < board.length; iBordOut++) {
      for(int iBordInner = 0; iBordInner < board[iBordOut].length; iBordInner++) {

        int[][] mark = new int[board.length][board[0].length];
        dfs(head, board, iBordOut, iBordInner, mark);
      }
    }

    // 开始校验结果
    List<String> results = new ArrayList<>();
    for(int i = 0; i < words.length; i++) {
      if(checkWord(words[i], head)) {
        results.add(words[i]);
      }
    }
    return results;
  }


  public boolean checkWord(String word, Node head) {
    char[] chars = word.toCharArray();
    Node used = head;
    for(int i = 0; i < chars.length; i++) {
      if(used.nextNodes[chars[i] - 'a'] == null) {
        return false;
      }
      used = used.nextNodes[chars[i] - 'a'];
    }
    return true;
  }


  public class Node{
    char value;
    Node[] nextNodes;

    public Node() {
    }

    public Node(char value) {
      this.value = value;
      this.nextNodes = new Node[26];
    }
  }


  public static class Coordinate{
    int iBordOut;
    int iBordInner;

    public Coordinate(int iBordOut, int iBordInner) {
      this.iBordOut = iBordOut;
      this.iBordInner = iBordInner;
    }
  }

  static int left = 0;
  static int right = 1;
  static int up = 2;
  static int down = 3;

  static Coordinate[] coordinates = new Coordinate[4];
  static {
    coordinates[left] = new Coordinate(0, -1);
    coordinates[right] = new Coordinate(0, 1);
    coordinates[up] = new Coordinate(-1, 0);
    coordinates[down] = new Coordinate(1, 0);
  }

  static int x = 0;

  private void dfs(Node node, char[][] board, int iBordOut, int iBordInner, int[][] mark) {

    // 越界 或者 已经是被遍历过的点，回退
    if((iBordOut >= board.length || iBordOut < 0) || (iBordInner >= board[0].length || iBordInner < 0)
            || mark[iBordOut][iBordInner] == 1) {
      return;
    }
    mark[iBordOut][iBordInner] = 1;

    // 如果节点没有作为树的起点则新建
    if(null == node.nextNodes[board[iBordOut][iBordInner] - 'a']) {
      node.nextNodes[board[iBordOut][iBordInner] - 'a'] = new Node(board[iBordOut][iBordInner]);
    }

//    x++;
//    System.out.println(x);
//    if(x == 4) {
//      System.out.print(board[iBordOut][iBordInner] - 'a');
//    }

    for(int i = 0; i < 4; i++) {
      //这里特别容易忽略，标记地图一定要备份更新
      int[][] markCopy = copyMark(mark);
      dfs(node.nextNodes[board[iBordOut][iBordInner] - 'a'],
              board,
              iBordOut + coordinates[i].iBordOut,
              iBordInner + coordinates[i].iBordInner,
              markCopy);
    }
  }

  private int[][] copyMark(int[][] mark) {
    int[][] markCopy = new int[mark.length][mark[0].length];
    for(int i = 0; i < mark.length; i++) {
      for(int i2 = 0; i2 < mark[0].length; i2++) {
        markCopy[i][i2] = (mark[i][i2]);
      }
    }
    return markCopy;
  }
}
