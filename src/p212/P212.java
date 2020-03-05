package p212;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 改良了一下，也是看了网友的思路，其实只需要变成对字符串建立前缀树，对矩阵进行校验即可，因为矩阵通过深搜出来的字符串数目远超测试用例中的字符串
 */
public class P212 {

  public static void main(String args[]) {
//    char[][] board = {
//            {'o','a','a','n'},
//            {'e','t','a','e'},
//            {'i','h','k','r'},
//            {'i','f','l','v'}
//    };
//    String[] words = {"oath","pea","eat","rain"};
//    String[] words = {"aaa"};
//    char[][] board = {
//            {'a', 'a'}
//    };

    String[] words = {"abbbababaa"};
    char[][] board = {{'b','b','a','a','b','a'},{'b','b','a','b','a','a'},{'b','b','b','b','b','b'},{'a','a','a','b','a','a'},{'a','b','a','a','b','b'}};


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


    P212 p212 = new P212();
    List<String> list = p212.findWords(board, words);
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
    for(int i = 0; i < words.length; i++) {
      buildTree(words[i], head);
    }

    // 校验结果
    Set<String> results = new HashSet<>();
    for(int iBordOut = 0; iBordOut < board.length; iBordOut++) {
      for(int iBordInner = 0; iBordInner < board[iBordOut].length; iBordInner++) {
        int[][] mark = new int[board.length][board[0].length];
        dfs(head, board, iBordOut, iBordInner, mark, results);
      }
    }
    return new ArrayList<>(results);
  }

  // 建树
  private void buildTree(String word, Node node) {
    char[] wordCharList = word.toCharArray();
    Node used = node;
    for(int i = 0; i < wordCharList.length; i++) {
      if(used.nextNodes[wordCharList[i] - 'a'] == null) {
        used.nextNodes[wordCharList[i] - 'a'] = new Node(wordCharList[i], used.string);
      }
      used = used.nextNodes[wordCharList[i] - 'a'];
    }
    used.isTail = true;
  }



  public class Node{
    char value;
    String string;
    boolean isTail = false;
    Node[] nextNodes;

    public Node() {
    }

    public Node(char value, String string) {
      this.value = value;
      this.nextNodes = new Node[26];
      this.string = string == null ? String.valueOf(value) : string + value;
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

  private void dfs(Node node, char[][] board, int iBordOut, int iBordInner, int[][] mark, Set<String> results) {

    // 越界 或者 已经是被遍历过的点，回退
    // 说明此次深搜到底了
    if((iBordOut >= board.length || iBordOut < 0) || (iBordInner >= board[0].length || iBordInner < 0)
            || mark[iBordOut][iBordInner] == 1) {
      if(node.isTail) results.add(node.string);
      return;
    }
    mark[iBordOut][iBordInner] = 1;

    // 如果节点没有，则匹配失败
    if(null == node.nextNodes[board[iBordOut][iBordInner] - 'a']) {
      return;
    }

    for(int i = 0; i < 4; i++) {
      //这里特别容易忽略，标记地图一定要备份更新
      int[][] markCopy = copyMark(mark);
      dfs(node.nextNodes[board[iBordOut][iBordInner] - 'a'],
              board,
              iBordOut + coordinates[i].iBordOut,
              iBordInner + coordinates[i].iBordInner,
              markCopy,
              results);
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
